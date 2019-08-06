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
public class Student implements Serializable {

    private static final long serialVersionUID = 1565084054553L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long studentId;

    /**
    * 
    * isNullAble:1
    */
    private String studentName;

    /**
    * 学号
    * isNullAble:1
    */
    private String studentCode;


    public void setStudentId(Long studentId){this.studentId = studentId;}

    public Long getStudentId(){return this.studentId;}

    public void setStudentName(String studentName){this.studentName = studentName;}

    public String getStudentName(){return this.studentName;}

    public void setStudentCode(String studentCode){this.studentCode = studentCode;}

    public String getStudentCode(){return this.studentCode;}
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                "studentName='" + studentName + '\'' +
                "studentCode='" + studentCode + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Student set;

        private ConditionBuilder where;

        public UpdateBuilder set(Student set){
            this.set = set;
            return this;
        }

        public Student getSet(){
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

    public static class QueryBuilder extends Student{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> studentIdList;

        public List<Long> getStudentIdList(){return this.studentIdList;}

        private Long studentIdSt;

        private Long studentIdEd;

        public Long getStudentIdSt(){return this.studentIdSt;}

        public Long getStudentIdEd(){return this.studentIdEd;}

        private List<String> studentNameList;

        public List<String> getStudentNameList(){return this.studentNameList;}


        private List<String> fuzzyStudentName;

        public List<String> getFuzzyStudentName(){return this.fuzzyStudentName;}

        private List<String> rightFuzzyStudentName;

        public List<String> getRightFuzzyStudentName(){return this.rightFuzzyStudentName;}
        private List<String> studentCodeList;

        public List<String> getStudentCodeList(){return this.studentCodeList;}


        private List<String> fuzzyStudentCode;

        public List<String> getFuzzyStudentCode(){return this.fuzzyStudentCode;}

        private List<String> rightFuzzyStudentCode;

        public List<String> getRightFuzzyStudentCode(){return this.rightFuzzyStudentCode;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder studentIdBetWeen(Long studentIdSt,Long studentIdEd){
            this.studentIdSt = studentIdSt;
            this.studentIdEd = studentIdEd;
            return this;
        }

        public QueryBuilder studentIdGreaterEqThan(Long studentIdSt){
            this.studentIdSt = studentIdSt;
            return this;
        }
        public QueryBuilder studentIdLessEqThan(Long studentIdEd){
            this.studentIdEd = studentIdEd;
            return this;
        }


        public QueryBuilder studentId(Long studentId){
            setStudentId(studentId);
            return this;
        }

        public QueryBuilder studentIdList(Long ... studentId){
            this.studentIdList = solveNullList(studentId);
            return this;
        }

        public QueryBuilder studentIdList(List<Long> studentId){
            this.studentIdList = studentId;
            return this;
        }

        public QueryBuilder fetchStudentId(){
            setFetchFields("fetchFields","studentId");
            return this;
        }

        public QueryBuilder excludeStudentId(){
            setFetchFields("excludeFields","studentId");
            return this;
        }

        public QueryBuilder fuzzyStudentName (List<String> fuzzyStudentName){
            this.fuzzyStudentName = fuzzyStudentName;
            return this;
        }

        public QueryBuilder fuzzyStudentName (String ... fuzzyStudentName){
            this.fuzzyStudentName = solveNullList(fuzzyStudentName);
            return this;
        }

        public QueryBuilder rightFuzzyStudentName (List<String> rightFuzzyStudentName){
            this.rightFuzzyStudentName = rightFuzzyStudentName;
            return this;
        }

        public QueryBuilder rightFuzzyStudentName (String ... rightFuzzyStudentName){
            this.rightFuzzyStudentName = solveNullList(rightFuzzyStudentName);
            return this;
        }

        public QueryBuilder studentName(String studentName){
            setStudentName(studentName);
            return this;
        }

        public QueryBuilder studentNameList(String ... studentName){
            this.studentNameList = solveNullList(studentName);
            return this;
        }

        public QueryBuilder studentNameList(List<String> studentName){
            this.studentNameList = studentName;
            return this;
        }

        public QueryBuilder fetchStudentName(){
            setFetchFields("fetchFields","studentName");
            return this;
        }

        public QueryBuilder excludeStudentName(){
            setFetchFields("excludeFields","studentName");
            return this;
        }

        public QueryBuilder fuzzyStudentCode (List<String> fuzzyStudentCode){
            this.fuzzyStudentCode = fuzzyStudentCode;
            return this;
        }

        public QueryBuilder fuzzyStudentCode (String ... fuzzyStudentCode){
            this.fuzzyStudentCode = solveNullList(fuzzyStudentCode);
            return this;
        }

        public QueryBuilder rightFuzzyStudentCode (List<String> rightFuzzyStudentCode){
            this.rightFuzzyStudentCode = rightFuzzyStudentCode;
            return this;
        }

        public QueryBuilder rightFuzzyStudentCode (String ... rightFuzzyStudentCode){
            this.rightFuzzyStudentCode = solveNullList(rightFuzzyStudentCode);
            return this;
        }

        public QueryBuilder studentCode(String studentCode){
            setStudentCode(studentCode);
            return this;
        }

        public QueryBuilder studentCodeList(String ... studentCode){
            this.studentCodeList = solveNullList(studentCode);
            return this;
        }

        public QueryBuilder studentCodeList(List<String> studentCode){
            this.studentCodeList = studentCode;
            return this;
        }

        public QueryBuilder fetchStudentCode(){
            setFetchFields("fetchFields","studentCode");
            return this;
        }

        public QueryBuilder excludeStudentCode(){
            setFetchFields("excludeFields","studentCode");
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

        public Student build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> studentIdList;

        public List<Long> getStudentIdList(){return this.studentIdList;}

        private Long studentIdSt;

        private Long studentIdEd;

        public Long getStudentIdSt(){return this.studentIdSt;}

        public Long getStudentIdEd(){return this.studentIdEd;}

        private List<String> studentNameList;

        public List<String> getStudentNameList(){return this.studentNameList;}


        private List<String> fuzzyStudentName;

        public List<String> getFuzzyStudentName(){return this.fuzzyStudentName;}

        private List<String> rightFuzzyStudentName;

        public List<String> getRightFuzzyStudentName(){return this.rightFuzzyStudentName;}
        private List<String> studentCodeList;

        public List<String> getStudentCodeList(){return this.studentCodeList;}


        private List<String> fuzzyStudentCode;

        public List<String> getFuzzyStudentCode(){return this.fuzzyStudentCode;}

        private List<String> rightFuzzyStudentCode;

        public List<String> getRightFuzzyStudentCode(){return this.rightFuzzyStudentCode;}

        public ConditionBuilder studentIdBetWeen(Long studentIdSt,Long studentIdEd){
            this.studentIdSt = studentIdSt;
            this.studentIdEd = studentIdEd;
            return this;
        }

        public ConditionBuilder studentIdGreaterEqThan(Long studentIdSt){
            this.studentIdSt = studentIdSt;
            return this;
        }
        public ConditionBuilder studentIdLessEqThan(Long studentIdEd){
            this.studentIdEd = studentIdEd;
            return this;
        }


        public ConditionBuilder studentIdList(Long ... studentId){
            this.studentIdList = solveNullList(studentId);
            return this;
        }

        public ConditionBuilder studentIdList(List<Long> studentId){
            this.studentIdList = studentId;
            return this;
        }

        public ConditionBuilder fuzzyStudentName (List<String> fuzzyStudentName){
            this.fuzzyStudentName = fuzzyStudentName;
            return this;
        }

        public ConditionBuilder fuzzyStudentName (String ... fuzzyStudentName){
            this.fuzzyStudentName = solveNullList(fuzzyStudentName);
            return this;
        }

        public ConditionBuilder rightFuzzyStudentName (List<String> rightFuzzyStudentName){
            this.rightFuzzyStudentName = rightFuzzyStudentName;
            return this;
        }

        public ConditionBuilder rightFuzzyStudentName (String ... rightFuzzyStudentName){
            this.rightFuzzyStudentName = solveNullList(rightFuzzyStudentName);
            return this;
        }

        public ConditionBuilder studentNameList(String ... studentName){
            this.studentNameList = solveNullList(studentName);
            return this;
        }

        public ConditionBuilder studentNameList(List<String> studentName){
            this.studentNameList = studentName;
            return this;
        }

        public ConditionBuilder fuzzyStudentCode (List<String> fuzzyStudentCode){
            this.fuzzyStudentCode = fuzzyStudentCode;
            return this;
        }

        public ConditionBuilder fuzzyStudentCode (String ... fuzzyStudentCode){
            this.fuzzyStudentCode = solveNullList(fuzzyStudentCode);
            return this;
        }

        public ConditionBuilder rightFuzzyStudentCode (List<String> rightFuzzyStudentCode){
            this.rightFuzzyStudentCode = rightFuzzyStudentCode;
            return this;
        }

        public ConditionBuilder rightFuzzyStudentCode (String ... rightFuzzyStudentCode){
            this.rightFuzzyStudentCode = solveNullList(rightFuzzyStudentCode);
            return this;
        }

        public ConditionBuilder studentCodeList(String ... studentCode){
            this.studentCodeList = solveNullList(studentCode);
            return this;
        }

        public ConditionBuilder studentCodeList(List<String> studentCode){
            this.studentCodeList = studentCode;
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

        private Student obj;

        public Builder(){
            this.obj = new Student();
        }

        public Builder studentId(Long studentId){
            this.obj.setStudentId(studentId);
            return this;
        }
        public Builder studentName(String studentName){
            this.obj.setStudentName(studentName);
            return this;
        }
        public Builder studentCode(String studentCode){
            this.obj.setStudentCode(studentCode);
            return this;
        }
        public Student build(){return obj;}
    }

}
