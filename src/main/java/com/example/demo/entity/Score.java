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
public class Score implements Serializable {

    private static final long serialVersionUID = 1565083832790L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 学生编号
    * isNullAble:0
    */
    private String studentCode;

    /**
    * 课程编号
    * isNullAble:0
    */
    private String courseCode;

    /**
    * 成绩
    * isNullAble:0
    */
    private Double score;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setStudentCode(String studentCode){this.studentCode = studentCode;}

    public String getStudentCode(){return this.studentCode;}

    public void setCourseCode(String courseCode){this.courseCode = courseCode;}

    public String getCourseCode(){return this.courseCode;}

    public void setScore(Double score){this.score = score;}

    public Double getScore(){return this.score;}
    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                "studentCode='" + studentCode + '\'' +
                "courseCode='" + courseCode + '\'' +
                "score='" + score + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Score set;

        private ConditionBuilder where;

        public UpdateBuilder set(Score set){
            this.set = set;
            return this;
        }

        public Score getSet(){
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

    public static class QueryBuilder extends Score{
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

        private List<String> studentCodeList;

        public List<String> getStudentCodeList(){return this.studentCodeList;}


        private List<String> fuzzyStudentCode;

        public List<String> getFuzzyStudentCode(){return this.fuzzyStudentCode;}

        private List<String> rightFuzzyStudentCode;

        public List<String> getRightFuzzyStudentCode(){return this.rightFuzzyStudentCode;}
        private List<String> courseCodeList;

        public List<String> getCourseCodeList(){return this.courseCodeList;}


        private List<String> fuzzyCourseCode;

        public List<String> getFuzzyCourseCode(){return this.fuzzyCourseCode;}

        private List<String> rightFuzzyCourseCode;

        public List<String> getRightFuzzyCourseCode(){return this.rightFuzzyCourseCode;}
        private List<Double> scoreList;

        public List<Double> getScoreList(){return this.scoreList;}

        private Double scoreSt;

        private Double scoreEd;

        public Double getScoreSt(){return this.scoreSt;}

        public Double getScoreEd(){return this.scoreEd;}

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

        public QueryBuilder scoreBetWeen(Double scoreSt,Double scoreEd){
            this.scoreSt = scoreSt;
            this.scoreEd = scoreEd;
            return this;
        }

        public QueryBuilder scoreGreaterEqThan(Double scoreSt){
            this.scoreSt = scoreSt;
            return this;
        }
        public QueryBuilder scoreLessEqThan(Double scoreEd){
            this.scoreEd = scoreEd;
            return this;
        }


        public QueryBuilder score(Double score){
            setScore(score);
            return this;
        }

        public QueryBuilder scoreList(Double ... score){
            this.scoreList = solveNullList(score);
            return this;
        }

        public QueryBuilder scoreList(List<Double> score){
            this.scoreList = score;
            return this;
        }

        public QueryBuilder fetchScore(){
            setFetchFields("fetchFields","score");
            return this;
        }

        public QueryBuilder excludeScore(){
            setFetchFields("excludeFields","score");
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

        public Score build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> studentCodeList;

        public List<String> getStudentCodeList(){return this.studentCodeList;}


        private List<String> fuzzyStudentCode;

        public List<String> getFuzzyStudentCode(){return this.fuzzyStudentCode;}

        private List<String> rightFuzzyStudentCode;

        public List<String> getRightFuzzyStudentCode(){return this.rightFuzzyStudentCode;}
        private List<String> courseCodeList;

        public List<String> getCourseCodeList(){return this.courseCodeList;}


        private List<String> fuzzyCourseCode;

        public List<String> getFuzzyCourseCode(){return this.fuzzyCourseCode;}

        private List<String> rightFuzzyCourseCode;

        public List<String> getRightFuzzyCourseCode(){return this.rightFuzzyCourseCode;}
        private List<Double> scoreList;

        public List<Double> getScoreList(){return this.scoreList;}

        private Double scoreSt;

        private Double scoreEd;

        public Double getScoreSt(){return this.scoreSt;}

        public Double getScoreEd(){return this.scoreEd;}


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

        public ConditionBuilder scoreBetWeen(Double scoreSt,Double scoreEd){
            this.scoreSt = scoreSt;
            this.scoreEd = scoreEd;
            return this;
        }

        public ConditionBuilder scoreGreaterEqThan(Double scoreSt){
            this.scoreSt = scoreSt;
            return this;
        }
        public ConditionBuilder scoreLessEqThan(Double scoreEd){
            this.scoreEd = scoreEd;
            return this;
        }


        public ConditionBuilder scoreList(Double ... score){
            this.scoreList = solveNullList(score);
            return this;
        }

        public ConditionBuilder scoreList(List<Double> score){
            this.scoreList = score;
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

        private Score obj;

        public Builder(){
            this.obj = new Score();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder studentCode(String studentCode){
            this.obj.setStudentCode(studentCode);
            return this;
        }
        public Builder courseCode(String courseCode){
            this.obj.setCourseCode(courseCode);
            return this;
        }
        public Builder score(Double score){
            this.obj.setScore(score);
            return this;
        }
        public Score build(){return obj;}
    }

}
