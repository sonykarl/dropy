package info.dropy.dropy.authentication.Customer.logic

import info.dropy.dropy.Customers.data.models.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class CustomerPrincipal @Autowired constructor(private val customer: Customer): UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        val authority = SimpleGrantedAuthority(customer.authority.name)
        authorities.add(authority)
        return authorities
    }

    override fun getPassword(): String {
        return customer.password
    }

    override fun getUsername(): String {
        return customer.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return customer.locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return customer.expired
    }

    override fun isEnabled(): Boolean {
        return customer.isEnabled
    }
}