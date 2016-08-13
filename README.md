
       设计思路：
              1.巧妙的利用java泛型技术，使得数据源的适配可以拥抱变化。
              2.把adapter的item作为了一个实体对象，这种方式借鉴了RecyclerView的ViewHolder的设计。
       

# Usage
# for Maven
    <dependency>
            <groupId>com.ioter</groupId>
            <artifactId>adapter</artifactId>
            <version>1.1.4</version>
            <type>pom</type>
    </dependency>
# for Gradle
    compile 'com.ioter:adapter:1.1.4'
# How to use?
       1. 把adapter作为子module引入到项目中（或者compile 'com.ioter:adapter:1.1.4'依赖）；
       2.在主module的build.gradle文件中加入如下引用：
       compile ‘com.jakewharton:butterknife:7.0.1’（因为adapter里的view采用此组件进行注入的）；
       3. new CommonAdapter复写getItemView方法，如下：
       listView.setAdapter(new CommonAdapter<ModelBean>(data) {
       @NonNull    
        @Override    
       public AdapterItem<ModelBean> getItemView(Object type) {
                     return new TextItem();   
              }
       });
# Contacts

          Github: https://github.com/binIoter
          Email: bin_iot@163.com
License
-------

    Copyright 2016 binIoter

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
