<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/21
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    public class Person {
        //    i.需求——输出Person类中普通属性，数组属性。list集合属性和map集合属性。
        private String name;
        private String[] phones;
        private List<String> cities;
        private Map<String, Object> map;

        public int getAge() {
            return 18;
        }

        public Person(String name, String[] phones, List<String> cities, Map<String, Object> map) {
            this.name = name;
            this.phones = phones;
            this.cities = cities;
            this.map = map;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String[] getPhones() {
            return phones;
        }

        public void setPhones(String[] phones) {
            this.phones = phones;
        }

        public List<String> getCities() {
            return cities;
        }

        public void setCities(List<String> cities) {
            this.cities = cities;
        }

        public Map<String, Object> getMap() {
            return map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "name=" + name +
                    ", phones=" + Arrays.toString(phones) +
                    ", cities=" + cities +
                    ", map=" + map +
                    '}';
        }
    }
%>

<%

    Person person = new Person();
    person.setName("username！");

    person.setPhones(new String[]{"18610541354","18688886666","18699998888"});

    List<String> cities = new ArrayList<String>();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");
    person.setCities(cities);

    Map<String,Object>map = new HashMap<String, Object>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    pageContext.setAttribute("p", person);

%>
输出 Person：${ p }<br/>
输出 Person 的 name 属性：${p.name} <br>
输出 Person 的 pnones 数组属性值：${p.phones[2]} <br>
输出 Person 的 cities 集合中的元素值：${p.cities} <br>
输出 Person 的 List 集合中个别元素值：${p.cities[2]} <br>
输出 Person 的 Map 集合: ${p.map} <br>
输出 Person 的 Map 集合中某个 key 的值: ${p.map.key3} <br>
输出 Person 的 age 属性：${p.age} <br>

</body>
</html>
