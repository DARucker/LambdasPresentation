package slidesStream;

public class cristian {


    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(x -> new ModelMapper()

                this::convertEntityToDTO).collect(Collectors.toList());
    }

    private PlayerDTO convertEntityToDTO(PlayerEntity playerEntity) {
        PlayerDTO playerDTO = new PlayerDTO(playerEntity.getPk_ID(), playerEntity.getNamePlayer());
        return playerDTO;
    }


}
