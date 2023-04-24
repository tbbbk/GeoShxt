package dao;

import entity.HeterogeneousMineral;
import entity.HomogeneousMineral;
import org.apache.ibatis.annotations.Param;
import service.HomogeneousMineralService;

import java.util.List;

public interface HomogeneousMineralDAO {
    /**
     * 插入
     */
    int insert(HomogeneousMineral homogeneousMineral);

    /**
     * 全部选择
     */
    List<HomogeneousMineral> selectAll();

    /**
     * 按照条件选择
     */
    List<HomogeneousMineral> selectByCondition(HomogeneousMineral homogeneousMineral);

    /**
     * 删除
     */
    int delete(@Param("id") int id);

    /**
     * 更新
     */
    int update(HomogeneousMineral homogeneousMineral);
}
