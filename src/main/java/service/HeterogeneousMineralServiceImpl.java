package service;


import dao.HeterogeneousMineralDAO;
import entity.HeterogeneousMineral;

import java.util.List;

public class HeterogeneousMineralServiceImpl implements HeterogeneousMineralService{
    private HeterogeneousMineralDAO heterogeneousMineralDAO;

    public void setHeterogeneousMineralDAO(HeterogeneousMineralDAO heterogeneousMineralDAO) {
        this.heterogeneousMineralDAO = heterogeneousMineralDAO;
    }

    @Override
    public int insert(HeterogeneousMineral heterogeneousMineral) {
        return this.heterogeneousMineralDAO.insert(heterogeneousMineral);
    }

    @Override
    public List<HeterogeneousMineral> selectAll() {
        return this.heterogeneousMineralDAO.selectAll();
    }

    @Override
    public List<HeterogeneousMineral> selectByCondition(HeterogeneousMineral heterogeneousMineral) {
        return this.heterogeneousMineralDAO.selectByCondition(heterogeneousMineral);
    }

    @Override
    public int delete(int id) {
        return this.heterogeneousMineralDAO.delete(id);
    }

    @Override
    public int update(HeterogeneousMineral heterogeneousMineral) {
        return this.heterogeneousMineralDAO.update(heterogeneousMineral);
    }
}