package bitcamp.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Board;

public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;

    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "board.delete", no);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Board> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "board.selectList");
        }
    }

    public int insert(Board board) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert(
                    "board.insert", board);
            sqlSession.commit();
            return count;
        }
    }

    public int update(Board board) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.update(
                    "board.update", board);
            sqlSession.commit();
            return count;
        }
    }

    public Board selectOne(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "board.selectOne", no);
        }  
    }
//    public static int delete(int no) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://13.125.9.121:3306/studydb",
//                "study", "1111");
//            PreparedStatement stmt = con.prepareStatement(
//                "delete from pms2_board where bno=?");) {
//            
//            stmt.setInt(1, no);
//            return stmt.executeUpdate();
//        } 
//    }
//    
//    public static  List<Board> selectList() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://13.125.9.121:3306/studydb",
//                "study", "1111");
//            PreparedStatement stmt = con.prepareStatement(
//                "select bno,titl,cdt from pms2_board");
//            ResultSet rs = stmt.executeQuery();) {
//            
//            ArrayList<Board> arr = new ArrayList<>();
//            while (rs.next()) {
//                Board board = new Board();
//                board.setNo(rs.getInt("bno"));
//                board.setTitle(rs.getString("titl"));
//                board.setCreatedDate(rs.getDate("cdt"));
//                arr.add(board);
//            }
//            return arr;
//        }
//    }
//
//    public static int insert(Board board) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://13.125.9.121:3306/studydb",
//                "study", "1111");
//            PreparedStatement stmt = con.prepareStatement(
//                "insert into pms2_board(titl,cont,cdt) values(?,?,now())");) {
//            
//            stmt.setString(1, board.getTitle());
//            stmt.setString(2, board.getContent());
//        
//            return stmt.executeUpdate();
//        }
//    }
//
//    public static int update(Board board) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://13.125.9.121:3306/studydb",
//                "study", "1111");
//            PreparedStatement stmt = con.prepareStatement(
//                "update pms2_board set titl=?, cont=?, cdt=now() where bno=?");) {
//            
//            stmt.setString(1, board.getTitle());
//            stmt.setString(2, board.getContent());
//            stmt.setInt(3, board.getNo());
//            return stmt.executeUpdate();
//        }
//    }
//
//    public static Board selectOne(int no) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://13.125.9.121:3306/studydb",
//                "study", "1111");
//            PreparedStatement stmt = con.prepareStatement(
//                "select bno,titl,cont,cdt from pms2_board where bno=?");) {
//            
//            stmt.setInt(1, no);
//            
//            try (ResultSet rs = stmt.executeQuery();) {
//                if (!rs.next()) 
//                    return null;
//                
//                Board board = new Board();
//                board.setNo(rs.getInt("bno"));
//                board.setTitle(rs.getString("titl"));
//                board.setContent(rs.getString("cont"));
//                board.setCreatedDate(rs.getDate("cdt"));
//                return board;
//            }
//        }  
//    }
}