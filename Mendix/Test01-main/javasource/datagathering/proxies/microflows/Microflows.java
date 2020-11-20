// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package datagathering.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the DataGathering module
	public static boolean afterStartUp(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("DataGathering.AfterStartUp").withParams(params).execute(context);
	}
	public static void documentDownload(IContext context, datagathering.proxies.Document _document, datagathering.proxies.DataEntry _dataEntry)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Document", _document == null ? null : _document.getMendixObject());
		params.put("DataEntry", _dataEntry == null ? null : _dataEntry.getMendixObject());
		Core.microflowCall("DataGathering.DocumentDownload").withParams(params).execute(context);
	}
	public static boolean documentUpload(IContext context, datagathering.proxies.Document _document)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Document", _document == null ? null : _document.getMendixObject());
		return (java.lang.Boolean) Core.microflowCall("DataGathering.DocumentUpload").withParams(params).execute(context);
	}
	public static void getStarted(IContext context, datagathering.proxies.DataEntry _dataEntry)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("DataEntry", _dataEntry == null ? null : _dataEntry.getMendixObject());
		Core.microflowCall("DataGathering.GetStarted").withParams(params).execute(context);
	}
	public static datagathering.proxies.DataEntry startApplication(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("DataGathering.StartApplication").withParams(params).execute(context);
		return result == null ? null : datagathering.proxies.DataEntry.initialize(context, result);
	}
	public static void submitApplication(IContext context, datagathering.proxies.DataEntry _form)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Form", _form == null ? null : _form.getMendixObject());
		Core.microflowCall("DataGathering.SubmitApplication").withParams(params).execute(context);
	}
}