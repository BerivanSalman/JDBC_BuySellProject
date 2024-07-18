package manage;

public class QueryManage {
    private String query01 = "Select name From categories Where slug='fashion';";
    private String query02 = "Insert Into cities(id,name,state_id,status,created_at) Values (?,?,?,?,?)";
    private String query03 = "Delete from cities where id=? and name=?";
    private String query04Insert = "Insert Into contacts(id,name, email,query_type, message) Values (?,?,?,?,?)";
    private String query04Update = "Update contacts Set message = ? where name =?";



    // -----------------------Getter---------------------
    public String getQuery01() {return query01;}
    public String getQuery02() {return query02;}
    public String getQuery03() {return query03;}
    public String getQuery04Insert() {return query04Insert;}
    public String getQuery04Update() {return query04Update;}
}
