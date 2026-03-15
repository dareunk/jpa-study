1. h2 사용하는 프로젝트 전체 구성
- application.properties 설정
- 프로젝트 생성시, 추가하는 의존성
2. entity 설정
- 총 5가지의 entity 사용
- Entity 생성시, 필수적인 어노테이션 (@Entity, @NoArgsConstructor, @Id) 
    -> 이 과정에서 Proxy 객체와 reflection을 이용한 객체 생성 설명하면 좋을듯 !
- @GeneratedValue
- @Column(nullable / length)
3. entity 간의 관계
- OneToMany / ManyToOne / OneToOne / ManyToMany
- 그 안의 설정값들 (mappedBy / cascade / fetch(FetchType) / @JoinColumn)
- ManyToMany 를 중간 테이블을 두는 이점 비교 (@JoinTable)

----------------------------------------------------------------------------------

4. Embedded
- @Embeddable / @Embedded
5. Repository
- JpaRepository의 기본구조 및 제공 메소드 (save / findById / findAll / count / deleteById ...)
- 컬럼이름을 기반으로 하는 메소드 만들기 (컬럼 조회, LIKE 검색, 날짜 범위 조회, 문자열 검색, 정렬, 개수세기, 존재 여부 확인, 첫번째/상위 몇개 컬럼 조회)
- jpql을 이용한 query 조회
- N+1 문제와 해결 방법
- entityGraph와 fetch join 비교
6. 테스트 코드
- 기본 데이터 insert (beforeEach나 beforeAll)
- 기본 repository 함수들 실행
- LAZY 로딩과 EAGER 로딩 비교
- AUTO(sequence) vs IDENTITY 방법 비교 (GeneratedType) -> id값을 언제 가져오는지 다름
- 프록시 객체 보여주기
- N+1 문제 해결
- cascade 비교
- orphanRemoval 비교
- 영속성 컨텍스트를 보여주기 위한 메소드 (비영속 엔티티 생성 vs 영속 엔티티 생성 비교)
   -> 1차 캐시에서 엔티티 조회 / 엔티티 변경(dirty Checking) / 트랜잭션 커밋 시점에 update 쿼리 자동 실행 (save() 함수 호출하지 않아도됨)
  ++ equals and Hashcode 재정의의 중요성 
