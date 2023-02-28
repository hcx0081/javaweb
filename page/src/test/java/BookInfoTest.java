import com.javaweb.dao.BookDao;
import com.javaweb.dao.impl.BookDaoImpl;

import java.sql.SQLException;

/**
 * {@code @Description:} 测试类
 */
public class BookInfoTest {
    
    public static void main(String[] args) throws SQLException {
        BookDao bookDao = new BookDaoImpl();
//        System.out.println(bookDao.queryPageTotalCount());
        System.out.println(bookDao.queryPageTotalCountByPrice(2, 20));
        System.out.println(bookDao.queryPageItemsByPrice(1, 4, 2, 20));
    }
    
}