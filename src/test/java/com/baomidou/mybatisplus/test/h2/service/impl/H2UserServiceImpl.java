/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.h2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.test.h2.entity.mapper.H2UserMapper;
import com.baomidou.mybatisplus.test.h2.entity.persistent.H2User;
import com.baomidou.mybatisplus.test.h2.service.IH2UserService;

/**
 * <p>
 * Service层测试
 * </p>
 *
 * @author hubin
 * @date 2017-01-30
 */
@Service
public class H2UserServiceImpl extends ServiceImpl<H2UserMapper, H2User> implements IH2UserService {

    @Autowired
    H2UserMapper userMapper;

    @Override
    public int myInsert(String name, int version) {
        return userMapper.myInsertWithNameVersion(name, version);
    }

    @Override
    public int myInsertWithParam(String name, int version) {
        H2User user = new H2User();
        user.setName(name);
        user.setVersion(version);
        return userMapper.myInsertWithParam(user);
    }

    @Override
    public int myInsertWithoutParam(String name, int version) {
        H2User user = new H2User();
        user.setName(name);
        user.setVersion(version);
        return userMapper.myInsertWithoutParam(user);
    }

    @Override
    public int myUpdate(Long id, String name) {
        return userMapper.myUpdateWithNameId(id, name);
    }
}
