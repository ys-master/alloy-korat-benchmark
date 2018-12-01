package korat.examples.LL;

public class SerializableObject {

    static int objectID = 0;

    private int myID;

    public SerializableObject() {
        myID = objectID++;
    }

    public String toString() {
        return "#" + myID;
    }

}