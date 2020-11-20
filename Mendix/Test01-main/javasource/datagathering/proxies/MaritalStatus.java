// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package datagathering.proxies;

public enum MaritalStatus
{
	Married(new java.lang.String[][] { new java.lang.String[] { "en_US", "Married" } }),
	Single(new java.lang.String[][] { new java.lang.String[] { "en_US", "Single" } }),
	Common_law(new java.lang.String[][] { new java.lang.String[] { "en_US", "Common-law" } }),
	Domestic_Partnership(new java.lang.String[][] { new java.lang.String[] { "en_US", "Domestic Partnership" } });

	private java.util.Map<java.lang.String, java.lang.String> captions;

	private MaritalStatus(java.lang.String[][] captionStrings)
	{
		this.captions = new java.util.HashMap<java.lang.String, java.lang.String>();
		for (java.lang.String[] captionString : captionStrings)
			captions.put(captionString[0], captionString[1]);
	}

	public java.lang.String getCaption(java.lang.String languageCode)
	{
		if (captions.containsKey(languageCode))
			return captions.get(languageCode);
		return captions.get("en_US");
	}

	public java.lang.String getCaption()
	{
		return captions.get("en_US");
	}
}