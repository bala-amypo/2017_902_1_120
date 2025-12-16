public class ApiKey{

    @Id
    private long id;
    @Column(unique=true);
    private String keyValue;
    private long ownerId;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ApiKey(){}

    public ApiKey(String keyValue,){
        this.keyValue=keyValue;

    }
    public getKeyValue(){
        return keyValue;
    }
    public setKeyValue(){
        return keyValue;
    }

}