package service;

import entity.HeterogeneousMineral;
import entity.HomogeneousMineral;

import java.util.List;

public interface HomogeneousMineralService {
    public int insert(HomogeneousMineral homogeneousMineral);

    public List<HomogeneousMineral> selectAll();

    public List<HomogeneousMineral> selectByCondition(HomogeneousMineral homogeneousMineral);

    public int delete(int id);

    public int update(HomogeneousMineral homogeneousMineral);
}
