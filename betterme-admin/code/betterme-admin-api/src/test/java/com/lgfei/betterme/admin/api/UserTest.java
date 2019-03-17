package com.lgfei.betterme.admin.api;

import java.util.ArrayList;
import java.util.List;

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

import com.alibaba.fastjson.JSONArray;
import com.lgfei.betterme.admin.model.User;
import com.lgfei.betterme.framework.model.vo.BatchDatasVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApiApplication.class)
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
    public void test_save()
        throws Exception
    {
        //调用接口，传入添加的用户参数
        mockMvc
            .perform(MockMvcRequestBuilders.post("/admin/user/save.json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userNo", "test_save")
                .param("account", "test_save")
                .param("name", "test_save")
                .param("password", "test_save"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void test_batchSave()
        throws Exception
    {
        // 构造参数
        User insert0 = new User();
        insert0.setUserNo("insert0");
        insert0.setAccount("insert0");
        insert0.setName("insert0");
        insert0.setPassword("insert0");
        User insert1 = new User();
        insert1.setUserNo("insert1");
        insert1.setAccount("insert1");
        insert1.setName("insert1");
        insert1.setPassword("insert1");
        List<User> inserted = new ArrayList<>();
        inserted.add(insert0);
        inserted.add(insert1);
        
        User update0 = new User();
        update0.setId(1107283156836298754L);
        update0.setName("update0");
        List<User> updated = new ArrayList<>();
        updated.add(update0);
        
        User delete0 = new User();
        delete0.setId(1L);
        User delete1 = new User();
        delete1.setId(2L);
        List<User> deleted = new ArrayList<>();
        deleted.add(delete0);
        deleted.add(delete1);
        
        BatchDatasVO<User> datas = new BatchDatasVO<>();
        datas.setInserted(inserted);
        datas.setUpdated(updated);
        datas.setDeleted(deleted);
        
        String datasJson = JSONArray.toJSONString(datas);
        
        //调用接口，传入添加的用户参数
        mockMvc
            .perform(MockMvcRequestBuilders.post("/admin/user/batchSave.json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(datasJson))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andDo(MockMvcResultHandlers.print());
    }
}
