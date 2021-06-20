package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.TestTable;

@Repository
public interface TestRepository extends JpaRepository<TestTable, Long> {
}
