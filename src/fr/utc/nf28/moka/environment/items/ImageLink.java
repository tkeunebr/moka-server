package fr.utc.nf28.moka.environment.items;

/**
 * An image item.
 */
public class ImageLink extends MokaItem {
	private static final String sType = "image";
	private String mUrl;

	public ImageLink() {
	}

	public ImageLink(String title, int x, int y, String url) {
		super(title, x, y, sType);
		mUrl = url;
	}

	public String getUrl() {
		return mUrl;
	}

	public void setUrl(String url) {
		this.mUrl = url;
	}

	public String toString() {
		return "image:" + mUrl + " " + super.toString();
	}

	@Override
	public void makeDefaultTitle() {
	   	mTitle = "Image "+String.valueOf(mId);
	}


}
