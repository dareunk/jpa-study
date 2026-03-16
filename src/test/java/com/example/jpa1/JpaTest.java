package com.example.jpa1;

import com.example.jpa1.embedded.*;
import com.example.jpa1.entity.*;
import com.example.jpa1.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@Rollback(false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JpaTest extends BaseDataModel {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PerformanceRepository performanceRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PerformanceArtistRepository performanceArtistRepository;
    @Autowired
    private EntityManager em;

    private Statistics stats;

    private static List<User> users;
    private static List<Artist> artists;
    private static Performance performance;
    private static List<Seat> seats;
    @Autowired
    private SeatRepository seatRepository;

    @BeforeEach
    void setupData() {
        //User 생성
        users = getUsers();
        userRepository.saveAll(users);

        //Artist 생성
        artists = getArtists();
        artistRepository.saveAll(artists);

        //Performance 생성
        PerformanceInfo performanceInfo = new PerformanceInfo("title", LocalDateTime.now(), "tera", "description", 120);
        performance = new Performance(performanceInfo);
        performanceRepository.save(performance);

        //PerformanceArtist 생성(연관관계)
        List<PerformanceArtist> paList = IntStream.range(0, artists.size())
                .mapToObj(i -> new PerformanceArtist(performance, artists.get(i), i + 1))
                .toList();
        performanceArtistRepository.saveAll(paList);

        Seat seat1 = new Seat("1");
        Ticket ticket = new Ticket(performance, seat1);
        ticket.addUser(users.get(0));
        ticketRepository.save(ticket);

        em.flush();
        em.clear();

        stats = em.unwrap(Session.class)
                .getSessionFactory()
                .getStatistics();
        stats.setStatisticsEnabled(true);
        stats.clear(); // 각 테스트 시작 전에 초기화

    }

    @Test
    void testFirstLevelCache() {
        stats.clear();

        System.out.println("===== First Level Cache =====");
        User user1 = userRepository.findById(users.get(0).getId()).orElseThrow();
        User user2 = userRepository.findById(users.get(0).getId()).orElseThrow();

        System.out.println(user1);
        System.out.println(user2);

        System.out.println("실행횟수: " + stats.getPrepareStatementCount());

        //동일성 보장 체크
        System.out.println(user1 == user2);
    }

    @Test
    void testEagerLoading() {
        stats.clear();
        System.out.println("===== EAGER LOADING =====");

        try {
            User loadUser = userRepository.findById(users.get(0).getId()).orElseThrow();
            System.out.println("EAGER LOADING: " + loadUser);

            System.out.println(loadUser.getTickets().getClass());

            loadUser.getTickets().forEach(System.out::println);
            System.out.println("EAGER 실행횟수: " + stats.getPrepareStatementCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testLazyLoading() {
        stats.clear();
        System.out.println("===== LAZY LOADING =====");

        try {
            User loadUser = userRepository.findById(users.get(0).getId()).orElseThrow();
            System.out.println("LAZY LOADING: " + loadUser);

            //Proxy 객체
            System.out.println(loadUser.getTickets().getClass());

            loadUser.getTickets().forEach(System.out::println);
            System.out.println("LAZY 실행횟수: " + stats.getPrepareStatementCount());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testGeneratedId() {
        System.out.println("===== Identity Generation =====");
        Artist artist = new Artist("dollar");
        artistRepository.save(artist);
        System.out.println("Identity Generation: " + artist.getId());

        System.out.println("===== Sequence Generation =====");
        User user = new User("dollar", "dollar@naver.com");
        userRepository.save(user);
        System.out.println("Sequence Generation: " + user.getId());
    }

    @Test
    void testOnePlusN() {
        stats.clear();
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(
                p -> System.out.println(p.getArtists())
        );
        System.out.println("1+N 실행횟수: " + stats.getPrepareStatementCount());

        //1+N 문제를 해결하는 방법
        //1. JOIN FETCH 이용
        stats.clear();
        System.out.println("===== JOIN FETCH =====");
        List<Performance> performances1 = performanceRepository.findAllWithArtists();
        performances1.forEach(
                p -> System.out.println(p.getArtists())
        );
        System.out.println("실행횟수: " + stats.getPrepareStatementCount());


        //2. @EntityGraph 이용
        stats.clear();
        System.out.println("===== EntityGraph =====");
        List<Performance> performances2 = performanceRepository.findAll();
        performances2.forEach(
                p -> System.out.println(p.getArtists())
        );
        System.out.println("실행횟수: " + stats.getPrepareStatementCount());

    }

    @Test
    void testCasCadeAndOrphanRemoval() {
        System.out.println("===== CasCade and OrphanRemoval =====");
        Seat seat = new Seat("5");
        Ticket ticket = new Ticket(performance, seat);

        ticketRepository.save(ticket);

        em.flush();

        ticketRepository.delete(ticket);
        em.flush();
    }

    @Test
    void testDirtyChecking() {
        System.out.println("===== Dirty Checking =====");

        User user = userRepository.findById(users.get(0).getId()).orElseThrow();
        Address address = new Address("newCity", "newStreet", "12233");

        //em.detach(user);
        user.changeAddress(address);
        //em.merge(user);
        System.out.println("==== DB 변경 ====");
        em.flush();
        em.clear();
    }
}