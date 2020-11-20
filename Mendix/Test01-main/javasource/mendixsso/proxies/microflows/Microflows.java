// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package mendixsso.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the MendixSSO module
	public static system.proxies.User authorizeRequestWithAccessToken(IContext context, java.lang.String _authorizationHeader)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AuthorizationHeader", _authorizationHeader);
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.AuthorizeRequestWithAccessToken").withParams(params).execute(context);
		return result == null ? null : system.proxies.User.initialize(context, result);
	}
	public static boolean checkUserRolesRemoved(IContext context, system.proxies.User _user)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		return (java.lang.Boolean) Core.microflowCall("MendixSSO.CheckUserRolesRemoved").withParams(params).execute(context);
	}
	public static void cleanupAuthRequest(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.CleanupAuthRequest").withParams(params).execute(context);
	}
	public static java.lang.String decrypt(IContext context, java.lang.String _encrypted)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Encrypted", _encrypted);
		return (java.lang.String) Core.microflowCall("MendixSSO.Decrypt").withParams(params).execute(context);
	}
	public static mendixsso.proxies.DecryptedToken dS_GetCurrentAccessToken(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetCurrentAccessToken").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static mendixsso.proxies.DecryptedToken dS_GetCurrentIdToken(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetCurrentIdToken").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static datagathering.proxies.MendixSSOUser dS_GetCurrentMendixSSOUser(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetCurrentMendixSSOUser").withParams(params).execute(context);
		return result == null ? null : datagathering.proxies.MendixSSOUser.initialize(context, result);
	}
	public static mendixsso.proxies.DecryptedToken dS_GetCurrentRefreshToken(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetCurrentRefreshToken").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static mendixsso.proxies.ForeignIdentity dS_GetForeignIdentity(IContext context, datagathering.proxies.MendixSSOUser _mendixSSOUser)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("MendixSSOUser", _mendixSSOUser == null ? null : _mendixSSOUser.getMendixObject());
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetForeignIdentity").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.ForeignIdentity.initialize(context, result);
	}
	public static mendixsso.proxies.MendixSSOConfigurationView dS_GetMendixSSOConfiguration(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.DS_GetMendixSSOConfiguration").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.MendixSSOConfigurationView.initialize(context, result);
	}
	public static java.lang.String encrypt(IContext context, java.lang.String _plain)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Plain", _plain);
		return (java.lang.String) Core.microflowCall("MendixSSO.Encrypt").withParams(params).execute(context);
	}
	public static mendixsso.proxies.DecryptedToken getAccessTokenAndEnsureNotExpiresSoon(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.GetAccessTokenAndEnsureNotExpiresSoon").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static java.lang.String getOpenIDForSSOUser(IContext context, system.proxies.User _user)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		return (java.lang.String) Core.microflowCall("MendixSSO.GetOpenIDForSSOUser").withParams(params).execute(context);
	}
	public static mendixsso.proxies.UserProfile getUserProfileFromUserInfoEndpoint(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.GetUserProfileFromUserInfoEndpoint").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.UserProfile.initialize(context, result);
	}
	public static void iVK_DecryptAndViewToken(IContext context, mendixsso.proxies.Token _token)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Token", _token == null ? null : _token.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_DecryptAndViewToken").withParams(params).execute(context);
	}
	public static void iVK_DeleteAllTokens(IContext context, java.util.List<mendixsso.proxies.Token> _tokenList)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		java.util.ArrayList<IMendixObject> listparam_tokenList = null;
		if (_tokenList != null)
		{
			listparam_tokenList = new java.util.ArrayList<>();
			for (mendixsso.proxies.Token obj : _tokenList)
				listparam_tokenList.add(obj.getMendixObject());
		}
		params.put("TokenList", listparam_tokenList);

		Core.microflowCall("MendixSSO.IVK_DeleteAllTokens").withParams(params).execute(context);
	}
	public static void iVK_DeleteExpiredTokens(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.IVK_DeleteExpiredTokens").withParams(params).execute(context);
	}
	public static void iVK_DeleteMendixSSOUser(IContext context, java.util.List<datagathering.proxies.MendixSSOUser> _mendixSSOUserList)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		java.util.ArrayList<IMendixObject> listparam_mendixSSOUserList = null;
		if (_mendixSSOUserList != null)
		{
			listparam_mendixSSOUserList = new java.util.ArrayList<>();
			for (datagathering.proxies.MendixSSOUser obj : _mendixSSOUserList)
				listparam_mendixSSOUserList.add(obj.getMendixObject());
		}
		params.put("MendixSSOUserList", listparam_mendixSSOUserList);

		Core.microflowCall("MendixSSO.IVK_DeleteMendixSSOUser").withParams(params).execute(context);
	}
	public static void iVK_DeleteToken(IContext context, mendixsso.proxies.Token _token)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Token", _token == null ? null : _token.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_DeleteToken").withParams(params).execute(context);
	}
	public static void iVK_NewLocalUser(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.IVK_NewLocalUser").withParams(params).execute(context);
	}
	public static void iVK_NewWebserviceUser(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.IVK_NewWebserviceUser").withParams(params).execute(context);
	}
	public static void iVK_RefreshTokens(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.IVK_RefreshTokens").withParams(params).execute(context);
	}
	public static void iVK_SaveChangedPassword(IContext context, mendixsso.proxies.AccountPasswordData _accountPasswordData)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AccountPasswordData", _accountPasswordData == null ? null : _accountPasswordData.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_SaveChangedPassword").withParams(params).execute(context);
	}
	public static void iVK_SaveChangedUser(IContext context, datagathering.proxies.MendixSSOUser _mendixSSOUser)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("MendixSSOUser", _mendixSSOUser == null ? null : _mendixSSOUser.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_SaveChangedUser").withParams(params).execute(context);
	}
	public static void iVK_SaveMyChangedPassword(IContext context, mendixsso.proxies.AccountPasswordData _accountPasswordData)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AccountPasswordData", _accountPasswordData == null ? null : _accountPasswordData.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_SaveMyChangedPassword").withParams(params).execute(context);
	}
	public static void iVK_SaveNewLocalUser(IContext context, mendixsso.proxies.AccountPasswordData _accountPasswordData)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AccountPasswordData", _accountPasswordData == null ? null : _accountPasswordData.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_SaveNewLocalUser").withParams(params).execute(context);
	}
	public static void iVK_ShowMyPasswordForm(IContext context, datagathering.proxies.MendixSSOUser _user)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_ShowMyPasswordForm").withParams(params).execute(context);
	}
	public static void iVK_ShowPasswordForm(IContext context, datagathering.proxies.MendixSSOUser _user)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		Core.microflowCall("MendixSSO.IVK_ShowPasswordForm").withParams(params).execute(context);
	}
	public static boolean mendixSSO_AfterStartup(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("MendixSSO.MendixSSO_AfterStartup").withParams(params).execute(context);
	}
	public static datagathering.proxies.MendixSSOUser mendixSSO_CreateUser(IContext context, mendixsso.proxies.UserProfile _userProfile, java.lang.String _uUID)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("UserProfile", _userProfile == null ? null : _userProfile.getMendixObject());
		params.put("UUID", _uUID);
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.MendixSSO_CreateUser").withParams(params).execute(context);
		return result == null ? null : datagathering.proxies.MendixSSOUser.initialize(context, result);
	}
	public static datagathering.proxies.MendixSSOUser mendixSSO_UpdateUser(IContext context, datagathering.proxies.MendixSSOUser _user, mendixsso.proxies.UserProfile _userProfile, java.lang.String _uUID)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		params.put("UserProfile", _userProfile == null ? null : _userProfile.getMendixObject());
		params.put("UUID", _uUID);
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.MendixSSO_UpdateUser").withParams(params).execute(context);
		return result == null ? null : datagathering.proxies.MendixSSOUser.initialize(context, result);
	}
	public static mendixsso.proxies.Response refreshTokens(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.RefreshTokens").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.Response.initialize(context, result);
	}
	public static void refreshUserRoles(IContext context, system.proxies.User _user, java.lang.String _uUID)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		params.put("UUID", _uUID);
		Core.microflowCall("MendixSSO.RefreshUserRoles").withParams(params).execute(context);
	}
	public static boolean retrieveUserRoles(IContext context, system.proxies.User _user, java.lang.String _uUID)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("User", _user == null ? null : _user.getMendixObject());
		params.put("UUID", _uUID);
		return (java.lang.Boolean) Core.microflowCall("MendixSSO.RetrieveUserRoles").withParams(params).execute(context);
	}
	public static void rS_NotifyUserRolesChanged(IContext context, java.lang.String _uUID, system.proxies.HttpRequest _httpRequest, system.proxies.HttpResponse _httpResponse)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("UUID", _uUID);
		params.put("httpRequest", _httpRequest == null ? null : _httpRequest.getMendixObject());
		params.put("httpResponse", _httpResponse == null ? null : _httpResponse.getMendixObject());
		Core.microflowCall("MendixSSO.RS_NotifyUserRolesChanged").withParams(params).execute(context);
	}
	public static void sE_DeleteExpiredTokens(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MendixSSO.SE_DeleteExpiredTokens").withParams(params).execute(context);
	}
	public static mendixsso.proxies.DecryptedToken sUB_DecryptToken(IContext context, mendixsso.proxies.Token _token)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Token", _token == null ? null : _token.getMendixObject());
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.SUB_DecryptToken").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static mendixsso.proxies.DecryptedToken sUB_GetDecryptedTokenByTypeForCurrentSession(IContext context, mendixsso.proxies.TokenType _tokenType)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("TokenType", _tokenType == null ? null : _tokenType.name());
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.SUB_GetDecryptedTokenByTypeForCurrentSession").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.DecryptedToken.initialize(context, result);
	}
	public static java.lang.String sUB_GetHttpHeaderValue(IContext context, java.lang.String _headerName, system.proxies.HttpResponse _httpResponse)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("HeaderName", _headerName);
		params.put("HttpResponse", _httpResponse == null ? null : _httpResponse.getMendixObject());
		return (java.lang.String) Core.microflowCall("MendixSSO.SUB_GetHttpHeaderValue").withParams(params).execute(context);
	}
	public static mendixsso.proxies.Token sUB_GetTokenByTypeForCurrentSession(IContext context, mendixsso.proxies.TokenType _tokenType)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("TokenType", _tokenType == null ? null : _tokenType.name());
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.SUB_GetTokenByTypeForCurrentSession").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.Token.initialize(context, result);
	}
	public static java.lang.String sUB_GetUserInfoFromIdentityProvider(IContext context, java.lang.String _accessToken)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AccessToken", _accessToken);
		return (java.lang.String) Core.microflowCall("MendixSSO.SUB_GetUserInfoFromIdentityProvider").withParams(params).execute(context);
	}
	public static mendixsso.proxies.Response sUB_RefreshTokens(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MendixSSO.SUB_RefreshTokens").withParams(params).execute(context);
		return result == null ? null : mendixsso.proxies.Response.initialize(context, result);
	}
	public static void sUB_ReplaceRenewedToken(IContext context, java.lang.String _tokenValue, mendixsso.proxies.TokenType _tokenType, java.lang.Long _expiresIn)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("TokenValue", _tokenValue);
		params.put("TokenType", _tokenType == null ? null : _tokenType.name());
		params.put("ExpiresIn", _expiresIn);
		Core.microflowCall("MendixSSO.SUB_ReplaceRenewedToken").withParams(params).execute(context);
	}
	public static java.lang.String sUB_ValidateHeaderAndReturnAccessToken(IContext context, java.lang.String _authorizationHeader)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("AuthorizationHeader", _authorizationHeader);
		return (java.lang.String) Core.microflowCall("MendixSSO.SUB_ValidateHeaderAndReturnAccessToken").withParams(params).execute(context);
	}
}