package uz.jl.services;

import uz.jl.mappers.GenericBaseMapper;
import uz.jl.repository.AbstractRepository;

public abstract class AbstractService<R extends AbstractRepository,
        M extends GenericBaseMapper> implements GenericBaseService{
    protected final R repository;
    protected final M mapper;

    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
