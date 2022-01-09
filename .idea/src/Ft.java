import java.io.Serializable;

//this family tree class acts as an implementation of the family member class
public class Ft implements Serializable {
    private static final long serialVersionUID = 1;
    // verion control

    // const ft by setting the roor to null

    public Ft() {
        this.root = null;
    }

    private Ft root;

    /**
     * sets the root
     * 
     * @param newRoot
     */

    public void setRoot(Ft newRoot) {
        this.root = newRoot;
    }

    /**
     *
     * @return
     */
    public boolean hasRoot() {
        return this.root != null;
    }

    /**
     *
     * @return
     */
    public Ft getRoot() {
        return this.root;
    }

}
