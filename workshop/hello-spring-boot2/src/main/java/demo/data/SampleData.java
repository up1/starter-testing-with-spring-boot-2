package demo.data;

import javax.transaction.Transactional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import demo.repositories.BookRepository;
import demo.repositories.BookTable;

@Service
@Profile(value = "dev")
public class SampleData implements InitializingBean {
    
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void afterPropertiesSet() throws Exception {
          bookRepository.save(new BookTable(1, "Dummy book"));
    }

}
