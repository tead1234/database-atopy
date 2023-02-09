package com.example.analyzingatopyexternalFactors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymtomResponseDTO<T> {
    // 들어가야할 거
    // entity에서 받아온 모든 정보, http 통신시 주고 받았던 것들
    // 리스트로 받아서 그걸 string으로 전달하는게 좋을듯?

    int status;
    T data;


}
