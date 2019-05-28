package extractor.DAO.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import extractor.model.taskschedule;
@Mapper
@Component
public interface taskscheduleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    int deleteByPrimaryKey(Integer taskscheduleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    int insert(taskschedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    int insertSelective(taskschedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    taskschedule selectByPrimaryKey(Integer taskscheduleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    int updateByPrimaryKeySelective(taskschedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taskschedule
     *
     * @mbg.generated Tue May 28 10:49:45 CST 2019
     */
    int updateByPrimaryKey(taskschedule record);
}