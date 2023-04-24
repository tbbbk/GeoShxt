package service;

import dao.HeterogeneousMineralDAO;
import entity.HeterogeneousMineral;

import java.util.List;

public interface HeterogeneousMineralService {
    public int insert(HeterogeneousMineral heterogeneousMineral);

    public List<HeterogeneousMineral> selectAll();

    public List<HeterogeneousMineral> selectByCondition(HeterogeneousMineral heterogeneousMineral);

    public int delete(int id);

    public int update(HeterogeneousMineral heterogeneousMineral);
}
