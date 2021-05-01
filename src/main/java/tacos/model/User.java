//package tacos.model;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
//@Entity
//public class User implements UserDetails {
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue
//	private Long id;
//	private final String username;
//	private final String password;
//	private final String fullname;
//	private final String street;
//	private final String city;
//	private final String zip;
//	private final String phoneNumber;
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return Arrays.asList(new SimpleGrantedAuthority("USER"));
//	}
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return this.password;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//}
