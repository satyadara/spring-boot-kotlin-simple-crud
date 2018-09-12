package com.satyadara.kotlincruddemo.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_user")
data class User(@Id @Column(name = "user_name") var name: String? = null,
                @Column(name = "user_address") var address: String? = null,
                @Column(name = "user_age") var age: Int? = null)
