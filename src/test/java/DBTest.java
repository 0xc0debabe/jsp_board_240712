import com.hmw.jsp.board.Main;
import com.hmw.jsp.board.util.MysqlUtil;
import com.hmw.jsp.board.util.SecSql;

import java.util.List;
import java.util.Map;

public class DBTest {
    public static void main(String[] args) {
        MysqlUtil.setDBInfo("localhost", "jspuser", "1234", "jspboard");
        MysqlUtil.setDevMode(true);

        SecSql sql = new SecSql();
        sql.append("SELECT *");
        sql.append("FROM article");
        sql.append("ORDER BY id DESC;");
        List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);
        System.out.println("articleListMap = " + articleListMap);


        Map<String, Object> articleMap = MysqlUtil.selectRow(new SecSql().append("SELECT * FROM article WHERE id = ?", 1));
        System.out.println("articleMap = " + articleMap);

        int id = MysqlUtil.selectRowIntValue(new SecSql().append("SELECT id FROM article WHERE id = ?", 1));
        System.out.println("articleId : " + id);

        boolean articleIsExits = MysqlUtil.selectRowBooleanValue(new SecSql().append("SELECT COUNT(*) > 0 FROM article WHERE id = ?", 3));
        System.out.println(articleIsExits);

        String newTitle = "새 제목";
        String newBody = "새 내용";

        sql = new SecSql();
        sql.append("INSERT INTO article");
        sql.append("SET regDate = NOW()");
        sql.append(", updateDate = NOW() ");
        sql.append(", title = ?", newTitle);
        sql.append(", `body` = ?", newBody);

        MysqlUtil.insert(sql);

        MysqlUtil.closeConnection();
    }
}
