package manage;

public class QueryManage {
    private String query01 = "Select name From categories Where slug='fashion';";
    private String query02 = "Insert Into cities(id,name,state_id,status,created_at) Values (?,?,?,?,?)";
    private String query03 = "Delete from cities where id=? and name=?";
    private String query04Insert = "Insert Into contacts(id,name, email,query_type, message) Values (?,?,?,?,?)";
    private String query04Update = "Update contacts Set message = ? where name =?";
    private String query05 = "Delete from contacts where email=?";
    private  String query06 ="Select coupon_id, COUNT(*) AS product_count From coupon_products Group By coupon_id";
    private String query07="SELECT phone FROM customer_addresses WHERE phone LIKE '%5%' LIMIT 3";



    // -----------------------Getter---------------------
    public String getQuery01() {return query01;}
    public String getQuery02() {return query02;}
    public String getQuery03() {return query03;}
    public String getQuery04Insert() {return query04Insert;}
    public String getQuery04Update() {return query04Update;}
    public String getQuery05() {return query05;}
    public String getQuery06() {return query06;}
    public String getQuery07() {return query07;}
}
