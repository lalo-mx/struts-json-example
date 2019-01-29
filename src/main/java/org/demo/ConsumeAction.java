/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.demo;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.json.annotations.SMDMethod;

public class ConsumeAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        if (request == null) {
            request = hsr;
        }
    }
    
    public String smd() {
        return SUCCESS;
    }
    
    private List<MyBean> consume(final Integer index) {
        final List<MyBean> results = new ArrayList<MyBean>();
        for(int i = 0; i<= index; i++) {
            final MyBean myBean1 = new MyBean();
            myBean1.setId(new Long(index+1));
            final List<String> names1 = new ArrayList<String>();
            names1.add("name1-" + index+1);
            names1.add("name1-" + index+2);
            myBean1.setOptions(names1);
            results.add(myBean1);
        }
        return results;
    }

    @SMDMethod
    public List<MyBean> consume0(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume1(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume2(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume3(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume4(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume5(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume6(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume7(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume8(final Integer index) {
        return consume(index);
    }

    @SMDMethod
    public List<MyBean> consume9(final Integer index) {
        return consume(index);
    }

}
