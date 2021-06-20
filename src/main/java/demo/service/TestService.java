package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.TestTable;
import demo.repository.TestRepository;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<TestTable> list() {
        return testRepository.findAll();
    }

    public void insert(TestTable testTable) {
        testRepository.save(testTable);
    }
}