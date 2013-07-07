/**
 * 
 */
package co.escapeideas.jira.web.authentiction;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import co.escapeideas.jira.authentiction.LoginService;

/**
 * @author tmullender
 *
 */
public class WSDLAuthenticationProvider implements AuthenticationProvider {

	private LoginService loginService;

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final Authentication response;
		if (loginService.login(authentication.getName(), (String)authentication.getCredentials())){
			response = authentication;
		} else {
			response = null;
		}
		return response;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
