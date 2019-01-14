package fall2018.csc2017.pong;
import android.graphics.RectF;

import java.io.IOException;
import java.io.Serializable;

/**
 * RectF that is Serializable
 * Excluded from unit test since this is just a Model
 */
public class SerializableRectF extends RectF implements Serializable {

    /**
     * Serial version
     */
    private static final long serialVersionUID = 1L;

    /**
     * Hold the RectF representation of this class
     */
    private RectF mRect;

    /**
     * Constructor of SerializableRectF
     * @param rect Built in Android RectF
     */
    SerializableRectF(RectF rect) {
        this.mRect = rect;
        this.mRect.left = rect.left;
        this.mRect.top = rect.top;
        this.mRect.right = rect.right;
        this.mRect.bottom = rect.bottom;
    }

    /**
     * Getter for RectF
     * @return RectF
     */
    RectF getRectF() {
        return this.mRect;
    }

    /**
     * Helps save serializable RectF
     * @param out OutPutStream
     * @throws IOException Exception when save fails
     */
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        float left = mRect.left;
        float top = mRect.top;
        float right = mRect.right;
        float bottom = mRect.bottom;

        out.writeFloat(left);
        out.writeFloat(top);
        out.writeFloat(right);
        out.writeFloat(bottom);
    }

    /**
     * Helps load serializable RectF
     * @param in InputStream
     * @throws IOException Exception when load fails
     * @throws ClassNotFoundException Exception when load not found
     */
    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        float left = in.readFloat();
        float top = in.readFloat();
        float right = in.readFloat();
        float bottom = in.readFloat();

        mRect = new RectF(left, top, right, bottom);
    }
}