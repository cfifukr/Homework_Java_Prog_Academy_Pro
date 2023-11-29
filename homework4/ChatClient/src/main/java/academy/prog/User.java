package academy.prog;

class User{
    String name;
    Status status;
    int id;

    public User(String name) {
        this.name = name;
        this.status = Status.ONLINE;
        this.id = 9999;
    }

    public int getId() {
        return id;
    }

    public User(String name, Status status, int id) {
        this.name = name;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public Status getStatus() {
        return status;
    }

    public void goOffline(){
        this.status = Status.OFFLINE;
    }

    public void goOnline(){
        this.status = Status.ONLINE;
    }


    @Override
    public String toString() {
        return name + "(" + status + ")";
    }
}
