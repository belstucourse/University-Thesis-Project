package com.belstu.thesisproject.psychouserservice.mapper;

import static java.lang.String.format;

import com.belstu.thesisproject.psychouserservice.domain.Doctor;
import com.belstu.thesisproject.psychouserservice.domain.Patient;
import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.dto.DoctorDto;
import com.belstu.thesisproject.psychouserservice.dto.PatientDto;
import com.belstu.thesisproject.psychouserservice.dto.UserDto;
import com.belstu.thesisproject.psychouserservice.exception.ClassCastException;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  Patient toPatientEntity(UserDto userDto);

  Doctor toDoctorEntity(UserDto userDto);

  UserDto toDto(User user);

  default User toEntity(final UserDto userDto) {
    if (userDto instanceof PatientDto) {
      return toPatientEntity(userDto);
    } else if (userDto instanceof DoctorDto) {
      return toDoctorEntity(userDto);
    } else {
      throw new ClassCastException(
          format("UserDto with %s id hasn't been cast to Entity", userDto.getId()));
    }
  }
}
