package com.lgfei.betterself.admin.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgfei.betterself.admin.domain.manager.IUserManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminWeApplication.class)
@WebAppConfiguration
public class AppTest
{
    @Autowired
    IUserManager manager;
    
    @Autowired
    private WebApplicationContext context;
    
    private MockMvc mockMvc;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @Before
    public void setupMockMvc()
        throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void testSend()
        throws Exception
    {
        /*        Long id = 1l;
        //调用接口，传入添加的用户参数
        mockMvc
            .perform(MockMvcRequestBuilders.get("/user/list").contentType(MediaType.APPLICATION_JSON_UTF8).content(
                mapper.writeValueAsString(id)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andDo(MockMvcResultHandlers.print());*/
        System.out.println(manager.selectById("1").getData().getName());
    }
}
