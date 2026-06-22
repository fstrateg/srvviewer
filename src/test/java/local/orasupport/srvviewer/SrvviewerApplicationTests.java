package local.orasupport.srvviewer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import local.orasupport.srvviewer.repository.SrvRepository;

import javax.sql.DataSource;


@SpringBootTest
class SrvviewerApplicationTests {

    @Autowired
    private DataSource dataSource;

	@Autowired
	private SrvRepository repository;

    @Test
    void testConnection() throws Exception {

        try (var conn = dataSource.getConnection()) {
            System.out.println(conn.getMetaData().getDatabaseProductName());
			String url=conn.getSchema();
            System.out.println(url);
        }
    }

	@Test
	void listAll() throws Exception {
		var list=repository.findAll();
		System.out.println(list);
	}
}
