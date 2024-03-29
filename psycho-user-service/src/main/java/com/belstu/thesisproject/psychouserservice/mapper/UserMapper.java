package com.belstu.thesisproject.psychouserservice.mapper;

import static com.belstu.thesisproject.psychouserservice.mapper.MapperErrorMessageKeys.CAST_EXCEPTION_MESSAGE_KEY;
import static java.lang.String.format;

import com.belstu.thesisproject.psychouserservice.domain.Admin;
import com.belstu.thesisproject.psychouserservice.domain.Client;
import com.belstu.thesisproject.psychouserservice.domain.Psychologist;
import com.belstu.thesisproject.psychouserservice.domain.Support;
import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.dto.AdminDto;
import com.belstu.thesisproject.psychouserservice.dto.ClientDto;
import com.belstu.thesisproject.psychouserservice.dto.PsychologistDto;
import com.belstu.thesisproject.psychouserservice.dto.SupportDto;
import com.belstu.thesisproject.psychouserservice.exception.ClassCastException;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  Client map(ClientDto dto);

  @InheritInverseConfiguration
  ClientDto map(Client entity);

  Support map(SupportDto dto);

  @InheritInverseConfiguration
  SupportDto map(Support entity);

  Psychologist map(PsychologistDto dto);

  @InheritInverseConfiguration
  PsychologistDto map(Psychologist entity);

  Admin map(AdminDto dto);

  @InheritInverseConfiguration
  AdminDto map(Admin entity);

  default com.belstu.thesisproject.psychouserservice.dto.UserDto map(final User entity) {
    if (entity instanceof Client) {
      return map((Client) entity);
    } else if (entity instanceof Admin) {
      return map((Admin) entity);
    } else if (entity instanceof Psychologist) {
      return map((Psychologist) entity);
    } else if (entity instanceof Support) {
      return map((Support) entity);
    } else {
      throw new ClassCastException(
          format(CAST_EXCEPTION_MESSAGE_KEY, entity.getClass(), entity.getId()));
    }
  }

  @InheritInverseConfiguration
  default User map(final com.belstu.thesisproject.psychouserservice.dto.UserDto dto) {
    if (dto instanceof ClientDto) {
      return map((ClientDto) dto);
    } else if (dto instanceof AdminDto) {
      return map((AdminDto) dto);
    } else if (dto instanceof PsychologistDto) {
      return map((PsychologistDto) dto);
    } else if (dto instanceof SupportDto) {
      return map((SupportDto) dto);
    } else {
      throw new ClassCastException(format(CAST_EXCEPTION_MESSAGE_KEY, dto.getClass(), dto.getId()));
    }
  }
}
