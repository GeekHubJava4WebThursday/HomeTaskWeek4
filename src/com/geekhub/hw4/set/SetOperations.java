package com.geekhub.hw4.set;

import java.util.Set;

public interface SetOperations {
    //��� ��������� � � � ����� (�=�), ���� ��� ������� �� ����� � ��� �� ���������
    boolean equals(Set a, Set b);

    //������������ (������) �������� � � � ���������� ��������� � ? �,
    //�������� �������� ����������� ���� �� ������ �� ���� ��������
    Set union(Set a, Set b) throws IllegalAccessException, InstantiationException;

    //��������� �������� � � � ���������� ��������� ��, �������� ��������
    //����������� ��������� �, �� �� ����������� ��������� �
    Set subtract(Set a, Set b)  throws IllegalAccessException, InstantiationException;

    //������������ (�������������) �������� � � � ���������� ��������� � ? �,
    //�������� �������� ����������� ��� ��������� �, ��� � ��������� �
    Set intersect(Set a, Set b) throws IllegalAccessException, InstantiationException;

    //������������ ��������� �������� � � � ���������� ��������� � ? �,
    //���������� ������������ ��������� �������� �� � ��, �� ���� � ? � = (��) ? (��)
    Set symmetricSubtract(Set a, Set b) throws InstantiationException, IllegalAccessException;
}
