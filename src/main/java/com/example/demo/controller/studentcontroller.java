public class studentcontroller{

    @Id
    private long id;
    @Column(unique=true);
    private String keyValue;
    private long ownerId;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public studentcontroller(){}

    public studentcontroller(String keyValue,){
        this.keyValue=keyValue;
        this.ownerId=ownerId;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;

    }
    public getKeyValue(){
        return keyValue;
    }
    public setKeyValue(int keyValue){
        this.keyValue=keyValue;
    }

}