package fr.utc.nf28.moka.environment.users;

import fr.utc.nf28.moka.environment.items.MokaItem;

public class User {
	private String mLastName;
	private String mFirstName;
	private String mIp;
	private int mColor;
	private MokaItem mCurrentItem;
	private String mAID;

	public User() {
	}

	public User(String firstName, String lastName) {
		mLastName = lastName;
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public int getColor() {
		return mColor;
	}

	public void setColor(int color) {
		mColor = color;
	}

	public MokaItem getCurrentItem() {
		return mCurrentItem;
	}

	public void setCurrentItem(MokaItem currentItem) {
		mCurrentItem = currentItem;
	}

	public String getIp() {
		return mIp;
	}

	public void setIp(String ip) {
		this.mIp = ip;
	}

	public String getAID() {
		return mAID;
	}

	public void setAID(String aid) {
		mAID = aid;
	}

	public String makePseudo() {
		return mFirstName + " " + mLastName.substring(0, 1);
	}

	@Override
	public String toString() {
		return mIp + " " + mFirstName + " " + mLastName;
	}
}
