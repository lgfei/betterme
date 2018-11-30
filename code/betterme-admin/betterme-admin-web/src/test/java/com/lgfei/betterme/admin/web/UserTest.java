package com.lgfei.betterme.admin.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminWeApplication.class)
@WebAppConfiguration
public class UserTest
{
    @Autowired
    private WebApplicationContext context;
    
    private MockMvc mockMvc;
    
    @Before
    public void setupMockMvc()
        throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void testUserList()
        throws Exception
    {
        //调用接口，传入添加的用户参数
        mockMvc
            .perform(MockMvcRequestBuilders.post("/user/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum", "1")
                .param("pageSize", "10"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andDo(MockMvcResultHandlers.print());
    }
}
