package STOMPUser;

public interface SpittleRepository  {
    Spittle save(Spittle spittle);

    Spittle findOne(Long id);
}
