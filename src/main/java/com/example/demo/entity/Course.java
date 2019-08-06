package com.example.demo.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author zhanghaiyan
*/
public class Course implements Serializable {

    private static final long serialVersionUID = 1565087101915L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 课程名称
    * isNullAble:1
    */
    private String courseName;

    /**
    * 课程编号
    * isNullAble:1
    */
    private String courseCode;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setCourseName(String courseName){this.courseName = courseName;}

    public String getCourseName(){return this.courseName;}

    public void setCourseCode(String courseCode){this.courseCode = courseCode;}

    public String getCourseCode(){return this.courseCode;}
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                "courseName='" + courseName + '\'' +
                "courseCode='" + courseCode + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Course set;

        private ConditionBuilder where;

        public UpdateBuilder set(Course set){
            this.set = set;
            return this;
        }

        public Course getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends Course{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> courseNameList;

        public List<String> getCourseNameList(){return this.courseNameList;}


        private List<String> fuzzyCourseName;

        public List<String> getFuzzyCourseName(){return this.fuzzyCourseName;}

        private List<String> rightFuzzyCourseName;

        public List<String> getRightFuzzyCourseName(){return this.rightFuzzyCourseName;}
        private List<String> courseCodeList;

        public List<String> getCourseCodeList(){return this.courseCodeList;}


        private List<String> fuzzyCourseCode;

        public List<String> getFuzzyCourseCode(){return this.fuzzyCourseCode;}

        private List<String> rightFuzzyCourseCode;

        public List<String> getRightFuzzyCourseCode(){return this.rightFuzzyCourseCode;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Long id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyCourseName (List<String> fuzzyCourseName){
            this.fuzzyCourseName = fuzzyCourseName;
            return this;
        }

        public QueryBuilder fuzzyCourseName (String ... fuzzyCourseName){
            this.fuzzyCourseName = solveNullList(fuzzyCourseName);
            return this;
        }

        public QueryBuilder rightFuzzyCourseName (List<String> rightFuzzyCourseName){
            this.rightFuzzyCourseName = rightFuzzyCourseName;
            return this;
        }

        public QueryBuilder rightFuzzyCourseName (String ... rightFuzzyCourseName){
            this.rightFuzzyCourseName = solveNullList(rightFuzzyCourseName);
            return this;
        }

        public QueryBuilder courseName(String courseName){
            setCourseName(courseName);
            return this;
        }

        public QueryBuilder courseNameList(String ... courseName){
            this.courseNameList = solveNullList(courseName);
            return this;
        }

        public QueryBuilder courseNameList(List<String> courseName){
            this.courseNameList = courseName;
            return this;
        }

        public QueryBuilder fetchCourseName(){
            setFetchFields("fetchFields","courseName");
            return this;
        }

        public QueryBuilder excludeCourseName(){
            setFetchFields("excludeFields","courseName");
            return this;
        }

        public QueryBuilder fuzzyCourseCode (List<String> fuzzyCourseCode){
            this.fuzzyCourseCode = fuzzyCourseCode;
            return this;
        }

        public QueryBuilder fuzzyCourseCode (String ... fuzzyCourseCode){
            this.fuzzyCourseCode = solveNullList(fuzzyCourseCode);
            return this;
        }

        public QueryBuilder rightFuzzyCourseCode (List<String> rightFuzzyCourseCode){
            this.rightFuzzyCourseCode = rightFuzzyCourseCode;
            return this;
        }

        public QueryBuilder rightFuzzyCourseCode (String ... rightFuzzyCourseCode){
            this.rightFuzzyCourseCode = solveNullList(rightFuzzyCourseCode);
            return this;
        }

        public QueryBuilder courseCode(String courseCode){
            setCourseCode(courseCode);
            return this;
        }

        public QueryBuilder courseCodeList(String ... courseCode){
            this.courseCodeList = solveNullList(courseCode);
            return this;
        }

        public QueryBuilder courseCodeList(List<String> courseCode){
            this.courseCodeList = courseCode;
            return this;
        }

        public QueryBuilder fetchCourseCode(){
            setFetchFields("fetchFields","courseCode");
            return this;
        }

        public QueryBuilder excludeCourseCode(){
            setFetchFields("excludeFields","courseCode");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public Course build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> courseNameList;

        public List<String> getCourseNameList(){return this.courseNameList;}


        private List<String> fuzzyCourseName;

        public List<String> getFuzzyCourseName(){return this.fuzzyCourseName;}

        private List<String> rightFuzzyCourseName;

        public List<String> getRightFuzzyCourseName(){return this.rightFuzzyCourseName;}
        private List<String> courseCodeList;

        public List<String> getCourseCodeList(){return this.courseCodeList;}


        private List<String> fuzzyCourseCode;

        public List<String> getFuzzyCourseCode(){return this.fuzzyCourseCode;}

        private List<String> rightFuzzyCourseCode;

        public List<String> getRightFuzzyCourseCode(){return this.rightFuzzyCourseCode;}

        public ConditionBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyCourseName (List<String> fuzzyCourseName){
            this.fuzzyCourseName = fuzzyCourseName;
            return this;
        }

        public ConditionBuilder fuzzyCourseName (String ... fuzzyCourseName){
            this.fuzzyCourseName = solveNullList(fuzzyCourseName);
            return this;
        }

        public ConditionBuilder rightFuzzyCourseName (List<String> rightFuzzyCourseName){
            this.rightFuzzyCourseName = rightFuzzyCourseName;
            return this;
        }

        public ConditionBuilder rightFuzzyCourseName (String ... rightFuzzyCourseName){
            this.rightFuzzyCourseName = solveNullList(rightFuzzyCourseName);
            return this;
        }

        public ConditionBuilder courseNameList(String ... courseName){
            this.courseNameList = solveNullList(courseName);
            return this;
        }

        public ConditionBuilder courseNameList(List<String> courseName){
            this.courseNameList = courseName;
            return this;
        }

        public ConditionBuilder fuzzyCourseCode (List<String> fuzzyCourseCode){
            this.fuzzyCourseCode = fuzzyCourseCode;
            return this;
        }

        public ConditionBuilder fuzzyCourseCode (String ... fuzzyCourseCode){
            this.fuzzyCourseCode = solveNullList(fuzzyCourseCode);
            return this;
        }

        public ConditionBuilder rightFuzzyCourseCode (List<String> rightFuzzyCourseCode){
            this.rightFuzzyCourseCode = rightFuzzyCourseCode;
            return this;
        }

        public ConditionBuilder rightFuzzyCourseCode (String ... rightFuzzyCourseCode){
            this.rightFuzzyCourseCode = solveNullList(rightFuzzyCourseCode);
            return this;
        }

        public ConditionBuilder courseCodeList(String ... courseCode){
            this.courseCodeList = solveNullList(courseCode);
            return this;
        }

        public ConditionBuilder courseCodeList(List<String> courseCode){
            this.courseCodeList = courseCode;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private Course obj;

        public Builder(){
            this.obj = new Course();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder courseName(String courseName){
            this.obj.setCourseName(courseName);
            return this;
        }
        public Builder courseCode(String courseCode){
            this.obj.setCourseCode(courseCode);
            return this;
        }
        public Course build(){return obj;}
    }

}
