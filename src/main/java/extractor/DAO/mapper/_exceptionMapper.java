package extractor.DAO.mapper;

import java.util.List;

import extractor.model._exception;

public interface _exceptionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    int deleteByPrimaryKey(Integer exceptionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    int insert(_exception record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    int insertSelective(_exception record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    _exception selectByPrimaryKey(Integer exceptionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    int updateByPrimaryKeySelective(_exception record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exception
     *
     * @mbg.generated Sun Jun 23 16:28:00 CST 2019
     */
    int updateByPrimaryKey(_exception record);
    List<_exception> selectByComp(Integer componentID);

}