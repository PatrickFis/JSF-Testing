package com.patrick.beans;

import javax.inject.Named;
import javax.interceptor.Interceptors;

import com.patrick.interceptors.BeanInterceptor;

@Named
@Interceptors(BeanInterceptor.class)
public class GameBean {

}
