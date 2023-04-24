package dao;

import entity.HeterogeneousMineral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeterogeneousMineralDAO {
    /**
     * 插入
     */
    int insert(HeterogeneousMineral heterogeneousMineral);

    /**
     * 全部选择
     */
    List<HeterogeneousMineral> selectAll();

    /**
     * 按照条件选择
     */
    List<HeterogeneousMineral> selectByCondition(HeterogeneousMineral heterogeneousMineral);

    /**
     * 删除
     */
    int delete(@Param("id") int id);

    /**
     * 更新
     */
    int update(HeterogeneousMineral heterogeneousMineral);
}
