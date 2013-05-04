package fr.utc.nf28.moka.environment.items;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A generic visual item.
 * The JsonTypeInfo annotation allows Jackson to include the real type (for example UmlClass) in the serialized string
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class MokaItem {
    private static int sIdIndex = 0;

    private int mId;
    private int mX;
    private int mY;
    private boolean mLocked = true;

    public MokaItem() {
        mId = sIdIndex++;
    }

    public MokaItem(int x, int y) {
        this();
        mX = x;
        mY = y;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getY() {
        return mY;
    }

    public void setY(int mY) {
        this.mY = mY;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public void move(int x, int y) {
        mX = x;
        mY = y;
    }

    public boolean isLocked() {
        return mLocked;
    }

    public void setLocked(boolean locked) {
        mLocked = locked;
    }

    public String toString() {
        return "id:" + mId + " x:" + mX + " y:" + mY;
    }
}