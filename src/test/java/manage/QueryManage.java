package manage;

public class QueryManage {
    private String query01 = "Select name From categories Where slug='fashion';";
    private String query02 = "Insert Into cities(id,name,state_id,status,created_at) Values (?,?,?,?,?)";



    // -----------------------Getter---------------------
    public String getQuery01() {return query01;}
    public String getQuery02() {return query02;}
}
