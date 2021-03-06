package com.image_processing.letters.EnglishAlphabet.Fonts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Arial_English {
	
	
	// lower case averages Customs	
	private static double[] a_Custom1_first = new double[] {0.394, 0.061, 0.0, 0.545};
	private static double[] a_Custom1_second = new double[] {0.0, 0.727, 0.0, 0.273};
	private static double[] a_Custom1_third = new double[] {0.364, 0.212, 0.424, 0.0};
	private static double[] a_Custom1_fourth = new double[] {0.353, 0.206, 0.412, 0.029};
	private static double[] a_Custom1_fifth = new double[] {0.11, 0.3, 0.56, 0.06, 0.0, 0.55};
	
	
	// lower case averages Arial
	private static double[] a_A_first = new double[] {0.230,	0.108,	0.252,	0.410};
	private static double[] a_A_second = new double[] {0.259,	0.074,	0.155,	0.512};
	private static double[] a_A_third = new double[] {0.012,	0.728,	0.124,	0.136};
	private static double[] a_A_fourth = new double[] {0.362,	0.083,	0.502,	0.054};
	private static double[] a_A_fifth = new double[] {0.243,	0.149,	0.407,	0.354,	1.221,	0.852};
		
	private static double[] b_A_first = new double[] {0.552,	0.248,	0.000,	0.200};
	private static double[] b_A_second = new double[] {0.022,	0.431,	0.000,	0.547};
	private static double[] b_A_third = new double[] {0.014,	0.516,	0.457,	0.013};
	private static double[] b_A_fourth = new double[] {0.554,	0.145,	0.301,	0.000};
	private static double[] b_A_fifth = new double[] {0.106,	0.153,	0.250,	0.377,	0.906,	1.169};

	private static double[] c_A_first = new double[] {0.340,	0.113,	0.000,	0.547};
	private static double[] c_A_second = new double[] {0.120,	0.401,	0.432,	0.046};
	private static double[] c_A_third = new double[] {0.145,	0.351,	0.052,	0.452};
	private static double[] c_A_fourth = new double[] {0.311,	0.149,	0.540,	0.000};
	private static double[] c_A_fifth = new double[] {0.197,	0.316,	0.504,	0.339,	1.014,	0.233};

	private static double[] d_A_first = new double[] {0.425,	0.025,	0.000,	0.551};
	private static double[] d_A_second = new double[] {0.154,	0.666,	0.000,	0.180};
	private static double[] d_A_third = new double[] {0.088,	0.550,	0.360,	0.002};
	private static double[] d_A_fourth = new double[] {0.496,	0.120,	0.378,	0.006};
	private static double[] d_A_fifth = new double[] {0.113,	0.149,	0.251,	0.443,	0.812,	1.140};
		
	private static double[] e_A_first = new double[] {0.357,	0.070,	0.000,	0.572};
	private static double[] e_A_second = new double[] {0.000,	0.398,	0.492,	0.110};
	private static double[] e_A_third = new double[] {0.109,	0.317,	0.082,	0.493};
	private static double[] e_A_fourth = new double[] {0.325,	0.097,	0.578,	0.000};
	private static double[] e_A_fifth = new double[] {0.214,	0.194,	0.480,	0.279,	1.525,	0.236};
				
	private static double[] f_A_first = new double[] {0.611,	0.000,	0.121,	0.308};
	private static double[] f_A_second = new double[] {0.006,	0.333,	0.233,	0.428};
	private static double[] f_A_third = new double[] {0.000,	0.754,	0.191,	0.056};
	private static double[] f_A_fourth = new double[] {0.566,	0.211,	0.223,	0.000};
	private static double[] f_A_fifth = new double[] {0.185,	0.074,	0.091,	1.036,	1.555,	0.498};
		
	private static double[] g_A_first = new double[] {0.445,	0.026,	0.006,	0.523};
	private static double[] g_A_second = new double[] {0.000,	0.834,	0.114,	0.053};
	private static double[] g_A_third = new double[] {0.288,	0.108,	0.467,	0.136};
	private static double[] g_A_fourth = new double[] {0.233,	0.199,	0.312,	0.257};
	private static double[] g_A_fifth = new double[] {0.195,	0.168,	0.356,	0.254,	1.228,	0.884};
		
	private static double[] h_A_first = new double[] {0.441,	0.235,	0.010,	0.315};
	private static double[] h_A_second = new double[] {0.004,	0.679,	0.097,	0.221};
	private static double[] h_A_third = new double[] {0.540,	0.172,	0.288,	0.000};
	private static double[] h_A_fourth = new double[] {0.392,	0.435,	0.173,	0.000};
	private static double[] h_A_fifth = new double[] {0.048,	0.066,	0.142,	0.508,	0.970,	2.465};
		
	private static double[] i_A_first = new double[] {0.793,	0.000,	0.000,	0.207};
	private static double[] i_A_second = new double[] {0.000,	0.816,	0.000,	0.184};
	private static double[] i_A_third = new double[] {0.000,	0.907,	0.093,	0.000};
	private static double[] i_A_fourth = new double[] {0.722,	0.000,	0.278,	0.000};
	private static double[] i_A_fifth = new double[] {0.000,	0.000,	0.000,	0.685,	1.213,	1.270};
		
	private static double[] j_A_first = new double[] {0.767,	0.005,	0.000,	0.228};
	private static double[] j_A_second = new double[] {0.000,	0.971,	0.000,	0.029};
	private static double[] j_A_third = new double[] {0.000,	0.650,	0.350,	0.000};
	private static double[] j_A_fourth = new double[] {0.684,	0.000,	0.111,	0.205};
	private static double[] j_A_fifth = new double[] {0.066,	0.045,	0.100,	0.503,	1.178,	1.243};
		
	private static double[] k_A_first = new double[] {0.415,	0.357,	0.008,	0.220};
	private static double[] k_A_second = new double[] {0.127,	0.352,	0.197,	0.324};
	private static double[] k_A_third = new double[] {0.254,	0.280,	0.307,	0.159};
	private static double[] k_A_fourth = new double[] {0.397,	0.354,	0.241,	0.008};
	private static double[] k_A_fifth = new double[] {0.013,	0.264,	0.363,	0.506,	0.876,	1.428};
		
	private static double[] l_A_first = new double[] {0.839,	0.000,	0.000,	0.161};
	private static double[] l_A_second = new double[] {0.000,	0.853,	0.014,	0.133};
	private static double[] l_A_third = new double[] {0.000,	0.924,	0.076,	0.000};
	private static double[] l_A_fourth = new double[] {0.774,	0.004,	0.222,	0.000};
	private static double[] l_A_fifth = new double[] {0.000,	0.013,	0.000,	0.533,	1.213,	1.270};
		
	private static double[] m_A_first = new double[] {0.268,	0.116,	0.000,	0.617};
	private static double[] m_A_second = new double[] {0.387,	0.422,	0.171,	0.019};
	private static double[] m_A_third = new double[] {0.368,	0.393,	0.232,	0.007};
	private static double[] m_A_fourth = new double[] {0.242,	0.473,	0.275,	0.010};
	private static double[] m_A_fifth = new double[] {0.062,	0.091,	0.200,	0.378,	0.314,	3.656};

	private static double[] n_A_first = new double[] {0.364,	0.081,	0.000,	0.556};
	private static double[] n_A_second = new double[] {0.081,	0.696,	0.175,	0.048};
	private static double[] n_A_third = new double[] {0.531,	0.204,	0.265,	0.000};
	private static double[] n_A_fourth = new double[] {0.324,	0.482,	0.188,	0.006};
	private static double[] n_A_fifth = new double[] {0.048,	0.079,	0.173,	0.416,	0.959,	2.568};
		
	private static double[] o_A_first = new double[] {0.508,	0.000,	0.000,	0.492};
	private static double[] o_A_second = new double[] {0.000,	0.509,	0.004,	0.487};
	private static double[] o_A_third = new double[] {0.000,	0.598,	0.402,	0.000};
	private static double[] o_A_fourth = new double[] {0.458,	0.003,	0.539,	0.000};
	private static double[] o_A_fifth = new double[] {0.252,	0.264,	0.504,	0.052,	0.694,	0.380};
		
	private static double[] p_A_first = new double[] {0.569,	0.009,	0.000,	0.422};
	private static double[] p_A_second = new double[] {0.000,	0.643,	0.033,	0.324};
	private static double[] p_A_third = new double[] {0.087,	0.392,	0.521,	0.000};
	private static double[] p_A_fourth = new double[] {0.501,	0.286,	0.212,	0.000};
	private static double[] p_A_fifth = new double[] {0.093,	0.118,	0.258,	0.266,	1.033,	1.271};

	private static double[] q_A_first = new double[] {0.541,	0.006,	0.013,	0.440};
	private static double[] q_A_second = new double[] {0.017,	0.661,	0.028,	0.294};
	private static double[] q_A_third = new double[] {0.262,	0.499,	0.219,	0.019};
	private static double[] q_A_fourth = new double[] {0.327,	0.154,	0.513,	0.006};
	private static double[] q_A_fifth = new double[] {0.102,	0.129,	0.263,	0.292,	0.900,	1.133};

	private static double[] r_A_first = new double[] {0.592,	0.000,	0.000,	0.408};
	private static double[] r_A_second = new double[] {0.023,	0.362,	0.334,	0.281};
	private static double[] r_A_third = new double[] {0.000,	0.920,	0.080,	0.000};
	private static double[] r_A_fourth = new double[] {0.536,	0.180,	0.281,	0.003};
	private static double[] r_A_fifth = new double[] {0.061,	0.068,	0.093,	0.676,	1.214,	1.361};

	private static double[] s_A_first = new double[] {0.291,	0.174,	0.057,	0.477};
	private static double[] s_A_second = new double[] {0.078,	0.262,	0.331,	0.330};
	private static double[] s_A_third = new double[] {0.181,	0.281,	0.508,	0.030};
	private static double[] s_A_fourth = new double[] {0.209,	0.144,	0.258,	0.389};
	private static double[] s_A_fifth = new double[] {0.334,	0.162,	0.508,	0.335,	1.293,	0.250};
		
	private static double[] t_A_first = new double[] {0.635,	0.000,	0.116,	0.238};
	private static double[] t_A_second = new double[] {0.011,	0.548,	0.165,	0.276};
	private static double[] t_A_third = new double[] {0.000,	0.786,	0.025,	0.189};
	private static double[] t_A_fourth = new double[] {0.579,	0.028,	0.393,	0.000};
	private static double[] t_A_fifth = new double[] {0.273,	0.075,	0.108,	1.163,	1.415,	0.43};

	private static double[] u_A_first = new double[] {0.354,	0.472,	0.000,	0.174};
	private static double[] u_A_second = new double[] {0.568,	0.132,	0.000,	0.300};
	private static double[] u_A_third = new double[] {0.036,	0.759,	0.065,	0.140};
	private static double[] u_A_fourth = new double[] {0.392,	0.083,	0.525,	0.000};
	private static double[] u_A_fifth = new double[] {0.052,	0.109,	0.175,	0.534,	0.960,	2.421};
				
	private static double[] v_A_first = new double[] {0.372,	0.239,	0.121,	0.268};
	private static double[] v_A_second = new double[] {0.435,	0.215,	0.000,	0.350};
	private static double[] v_A_third = new double[] {0.010,	0.665,	0.224,	0.102};
	private static double[] v_A_fourth = new double[] {0.351,	0.265,	0.359,	0.024};
	private static double[] v_A_fifth = new double[] {0.000,	0.883,	0.045,	0.544,	0.500,	0.156};
				
	private static double[] w_A_first = new double[] {0.424,	0.239,	0.059,	0.278};
	private static double[] w_A_second = new double[] {0.271,	0.343,	0.025,	0.361};
	private static double[] w_A_third = new double[] {0.277,	0.424,	0.299,	0.000};
	private static double[] w_A_fourth = new double[] {0.267,	0.412,	0.283,	0.038};
	private static double[] w_A_fifth = new double[] {0.000,	0.393,	0.038,	0.611,	0.105,	0.688};
		
	private static double[] x_A_first = new double[] {0.357,	0.140,	0.168,	0.335};
	private static double[] x_A_second = new double[] {0.106,	0.416,	0.193,	0.286};
	private static double[] x_A_third = new double[] {0.214,	0.323,	0.329,	0.134};
	private static double[] x_A_fourth = new double[] {0.293,	0.242,	0.268,	0.198};
	private static double[] x_A_fifth = new double[] {0.000,	0.652,	0.393,	0.480,	0.993,	0.000};
		
	private static double[] y_A_first = new double[] {0.418,	0.235,	0.130,	0.217};
	private static double[] y_A_second = new double[] {0.323,	0.278,	0.057,	0.342};
	private static double[] y_A_third = new double[] {0.000,	0.689,	0.311,	0.000};
	private static double[] y_A_fourth = new double[] {0.396,	0.156,	0.244,	0.204};
	private static double[] y_A_fifth = new double[] {0.037,	0.745,	0.113,	0.474,	0.603,	0.040};
				
	private static double[] z_A_first = new double[] {0.363,	0.026,	0.300,	0.312};
	private static double[] z_A_second = new double[] {0.000,	0.369,	0.196,	0.435};
	private static double[] z_A_third = new double[] {0.000,	0.345,	0.275,	0.380};
	private static double[] z_A_fourth = new double[] {0.291,	0.034,	0.500,	0.175};
	private static double[] z_A_fifth = new double[] {0.000,	0.148,	0.340,	0.459,	2.573,	0.123};
		

		
	// upper case averages
	private static double[] A_A_first = new double[] {0.447,	0.149,	0.000,	0.405};
	private static double[] A_A_second = new double[] {0.000,	0.720,	0.000,	0.280};
	private static double[] A_A_third = new double[] {0.272,	0.115,	0.602,	0.011};
	private static double[] A_A_fourth = new double[] {0.400,	0.223,	0.236,	0.141};
	private static double[] A_A_fifth = new double[] {0.000,	0.989,	0.052,	0.423,	0.403,	0.000};
				
	private static double[] B_A_first = new double[] {0.527,	0.000,	0.000,	0.473};
	private static double[] B_A_second = new double[] {0.000,	0.542,	0.116,	0.343};
	private static double[] B_A_third = new double[] {0.000,	0.578,	0.297,	0.126};
	private static double[] B_A_fourth = new double[] {0.484,	0.000,	0.516,	0.000};
	private static double[] B_A_fifth = new double[] {0.136,	0.168,	0.229,	0.188,	1.282,	0.541};
		
	private static double[] C_A_first = new double[] {0.325,	0.118,	0.000,	0.556};
	private static double[] C_A_second = new double[] {0.128,	0.384,	0.463,	0.025};
	private static double[] C_A_third = new double[] {0.158,	0.336,	0.027,	0.479};
	private static double[] C_A_fourth = new double[] {0.306,	0.137,	0.557,	0.000};
	private static double[] C_A_fifth = new double[] {0.321,	0.314,	0.563,	0.160,	0.659,	0.133};

	private static double[] D_A_first = new double[] {0.528,	0.000,	0.000,	0.472};
	private static double[] D_A_second = new double[] {0.000,	0.544,	0.000,	0.456};
	private static double[] D_A_third = new double[] {0.000,	0.578,	0.422,	0.000};
	private static double[] D_A_fourth = new double[] {0.502,	0.000,	0.498,	0.000};
	private static double[] D_A_fifth = new double[] {0.127,	0.174,	0.238,	0.178,	1.192,	0.728};
		
	private static double[] E_A_first = new double[] {0.339,	0.111,	0.029,	0.520};
	private static double[] E_A_second = new double[] {0.000,	0.252,	0.374,	0.374};
	private static double[] E_A_third = new double[] {0.000,	0.251,	0.378,	0.371};
	private static double[] E_A_fourth = new double[] {0.318,	0.108,	0.526,	0.048};
	private static double[] E_A_fifth = new double[] {0.000,	0.003,	0.009,	0.631,	4.244,	0.820,};
		
	private static double[] F_A_first = new double[] {0.449,	0.000,	0.000,	0.551};
	private static double[] F_A_second = new double[] {0.000,	0.376,	0.507,	0.117};
	private static double[] F_A_third = new double[] {0.000,	0.177,	0.407,	0.417};
	private static double[] F_A_fourth = new double[] {0.414,	0.384,	0.195,	0.007};
	private static double[] F_A_fifth = new double[] {0.000,	0.040,	0.015,	0.668,	2.753,	0.837};
		
	private static double[] G_A_first = new double[] {0.276,	0.192,	0.013,	0.519};
	private static double[] G_A_second = new double[] {0.111,	0.391,	0.404,	0.094};
	private static double[] G_A_third = new double[] {0.221,	0.114,	0.164,	0.501};
	private static double[] G_A_fourth = new double[] {0.260,	0.219,	0.521,	0.000};
	private static double[] G_A_fifth = new double[] {0.314,	0.203,	0.458,	0.306,	1.428,	0.524};
		
	private static double[] H_A_first = new double[] {0.362,	0.303,	0.006,	0.329};
	private static double[] H_A_second = new double[] {0.303,	0.414,	0.000,	0.283};
	private static double[] H_A_third = new double[] {0.347,	0.354,	0.299,	0.000};
	private static double[] H_A_fourth = new double[] {0.342,	0.341,	0.310,	0.008};
	private static double[] H_A_fifth = new double[] {0.000,	0.005,	0.003,	0.692,	1.141,	2.756};
		
	private static double[] I_A_first = new double[] {0.845,	0.000,	0.000,	0.155};
	private static double[] I_A_second = new double[] {0.000,	0.865,	0.000,	0.135};
	private static double[] I_A_third = new double[] {0.000,	0.922,	0.074,	0.004};
	private static double[] I_A_fourth = new double[] {0.776,	0.007,	0.217,	0.000};
	private static double[] I_A_fifth = new double[] {0.000,	0.005,	0.000,	0.558,	1.173,	1.295};
	
	private static double[] J_A_first = new double[] {0.554,	0.238,	0.000,	0.208};
	private static double[] J_A_second = new double[] {0.000,	0.879,	0.121,	0.000};
	private static double[] J_A_third = new double[] {0.364,	0.066,	0.539,	0.031};
	private static double[] J_A_fourth = new double[] {0.371,	0.217,	0.005,	0.407};
	private static double[] J_A_fifth = new double[] {0.081,	0.138,	0.236,	0.402,	0.928,	1.191};
		
	private static double[] K_A_first = new double[] {0.459,	0.249,	0.000,	0.293};
	private static double[] K_A_second = new double[] {0.102,	0.366,	0.247,	0.284};
	private static double[] K_A_third = new double[] {0.214,	0.296,	0.289,	0.201};
	private static double[] K_A_fourth = new double[] {0.377,	0.356,	0.267,	0.000};
	private static double[] K_A_fifth = new double[] {0.010,	0.203,	0.605,	0.378,	0.391,	1.485};
		
	private static double[] L_A_first = new double[] {0.598,	0.190,	0.000,	0.212};
	private static double[] L_A_second = new double[] {0.000,	0.886,	0.000,	0.114};
	private static double[] L_A_third = new double[] {0.000,	0.196,	0.319,	0.485};
	private static double[] L_A_fourth = new double[] {0.541,	0.000,	0.459,	0.000};
	private static double[] L_A_fifth = new double[] {0.000,	0.000,	0.000,	0.570,	1.669,	1.184};
		
	private static double[] M_A_first = new double[] {0.379,	0.331,	0.000,	0.290};
	private static double[] M_A_second = new double[] {0.254,	0.498,	0.073,	0.176};
	private static double[] M_A_third = new double[] {0.432,	0.327,	0.241,	0.000};
	private static double[] M_A_fourth = new double[] {0.460,	0.377,	0.161,	0.002};
	private static double[] M_A_fifth = new double[] {0.003,	0.481,	0.025,	0.398,	0.223,	2.973};
		
	private static double[] N_A_first = new double[] {0.302,	0.351,	0.000,	0.348};
	private static double[] N_A_second = new double[] {0.386,	0.458,	0.000,	0.156};
	private static double[] N_A_third = new double[] {0.407,	0.221,	0.372,	0.000};
	private static double[] N_A_fourth = new double[] {0.327,	0.512,	0.154,	0.007};
	private static double[] N_A_fifth = new double[] {0.000,	0.340,	0.193,	0.422,	0.243,	2.858};
		
	private static double[] O_A_first = new double[] {0.499,	0.000,	0.000,	0.501};
	private static double[] O_A_second = new double[] {0.000,	0.510,	0.000,	0.490};
	private static double[] O_A_third = new double[] {0.000,	0.550,	0.450,	0.000};
	private static double[] O_A_fourth = new double[] {0.471,	0.000,	0.529,	0.000};
	private static double[] O_A_fifth = new double[] {0.299,	0.305,	0.543,	0.038,	0.618,	0.228};
		
	private static double[] P_A_first = new double[] {0.550,	0.000,	0.000,	0.450};
	private static double[] P_A_second = new double[] {0.000,	0.526,	0.036,	0.438};
	private static double[] P_A_third = new double[] {0.000,	0.347,	0.654,	0.000};
	private static double[] P_A_fourth = new double[] {0.513,	0.286,	0.198,	0.003};
	private static double[] P_A_fifth = new double[] {0.102,	0.092,	0.189,	0.371,	1.163,	0.909};
		
	private static double[] Q_A_first = new double[] {0.478,	0.000,	0.000,	0.522};
	private static double[] Q_A_second = new double[] {0.000,	0.610,	0.014,	0.376};
	private static double[] Q_A_third = new double[] {0.080,	0.412,	0.394,	0.115};
	private static double[] Q_A_fourth = new double[] {0.392,	0.021,	0.586,	0.000};
	private static double[] Q_A_fifth = new double[] {0.316,	0.289,	0.506,	0.116,	0.621,	0.179};
						
	private static double[] R_A_first = new double[] {0.388,	0.042,	0.000,	0.570};
	private static double[] R_A_second = new double[] {0.000,	0.606,	0.181,	0.213};
	private static double[] R_A_third = new double[] {0.345,	0.176,	0.402,	0.077};
	private static double[] R_A_fourth = new double[] {0.366,	0.343,	0.291,	0.000};
	private static double[] R_A_fifth = new double[] {0.090,	0.277,	0.306,	0.368,	0.773,	0.992};
		
	private static double[] S_A_first = new double[] {0.289,	0.184,	0.082,	0.446};
	private static double[] S_A_second = new double[] {0.099,	0.240,	0.341,	0.319};
	private static double[] S_A_third = new double[] {0.200,	0.286,	0.474,	0.039};
	private static double[] S_A_fourth = new double[] {0.222,	0.139,	0.248,	0.391};
	private static double[] S_A_fifth = new double[] {0.357,	0.218,	0.550,	0.269,	1.078,	0.143};
		
	private static double[] T_A_first = new double[] {0.537,	0.000,	0.365,	0.098};
	private static double[] T_A_second = new double[] {0.000,	0.171,	0.014,	0.815};
	private static double[] T_A_third = new double[] {0.000,	0.651,	0.349,	0.000};
	private static double[] T_A_fourth = new double[] {0.507,	0.311,	0.182,	0.000};
	private static double[] T_A_fifth = new double[] {0.000,	0.000,	0.000,	0.688,	1.578,	1.047};
		
	private static double[] U_A_first = new double[] {0.361,	0.495,	0.008,	0.135};
	private static double[] U_A_second = new double[] {0.500,	0.156,	0.004,	0.340};
	private static double[] U_A_third = new double[] {0.152,	0.663,	0.055,	0.130};
	private static double[] U_A_fourth = new double[] {0.347,	0.106,	0.547,	0.00};
	private static double[] U_A_fifth = new double[] {0.106,	0.136,	0.235,	0.246,	0.580,	2.240};
		
	private static double[] V_A_first = new double[] {0.357,	0.275,	0.129,	0.239};
	private static double[] V_A_second = new double[] {0.447,	0.243,	0.000,	0.309};
	private static double[] V_A_third = new double[] {0.071,	0.580,	0.209,	0.140};
	private static double[] V_A_fourth = new double[] {0.336,	0.283,	0.353,	0.028};
	private static double[] V_A_fifth = new double[] {0.000,	1.030,	0.046,	0.353,	0.129,	0.018};
		
	private static double[] W_A_first = new double[] {0.434,	0.275,	0.050,	0.242};
	private static double[] W_A_second = new double[] {0.316,	0.339,	0.014,	0.331};
	private static double[] W_A_third = new double[] {0.312,	0.402,	0.278,	0.009};
	private static double[] W_A_fourth = new double[] {0.244,	0.444,	0.282,	0.030};
	private static double[] W_A_fifth = new double[] {0.000,	0.421,	0.043,	0.372,	0.000,	0.270};
		
	private static double[] X_A_first = new double[] {0.345,	0.183,	0.171,	0.301};
	private static double[] X_A_second = new double[] {0.149,	0.383,	0.196,	0.272};
	private static double[] X_A_third = new double[] {0.243,	0.291,	0.316,	0.150};
	private static double[] X_A_fourth = new double[] {0.283,	0.245,	0.252,	0.220};
	private static double[] X_A_fifth = new double[] {0.000,	0.630,	0.577,	0.302,	0.203,	0.000};
		
	private static double[] Y_A_first = new double[] {0.416,	0.096,	0.250,	0.238};
	private static double[] Y_A_second = new double[] {0.308,	0.239,	0.004,	0.449};
	private static double[] Y_A_third = new double[] {0.006,	0.590,	0.310,	0.095};
	private static double[] Y_A_fourth = new double[] {0.415,	0.342,	0.208,	0.035};
	private static double[] Y_A_fifth = new double[] {0.000,	0.589,	0.325,	0.413,	0.167,	0.790};
		
	private static double[] Z_A_first = new double[] {0.355,	0.024,	0.313,	0.308};
	private static double[] Z_A_second = new double[] {0.000,	0.379,	0.218,	0.404};
	private static double[] Z_A_third = new double[] {0.000,	0.332,	0.274,	0.394};
	private static double[] Z_A_fourth = new double[] {0.314,	0.026,	0.464,	0.195};
	private static double[] Z_A_fifth = new double[] {0.000,	0.219,	0.359,	0.383,	2.770,	0.018};
		


		
	// numbers case averages
	private static double[] Zero_A_first = new double[] {0.586,	0.000,	0.000,	0.414};
	private static double[] Zero_A_second = new double[] {0.000,	0.582,	0.007,	0.412};
	private static double[] Zero_A_third = new double[] {0.000,	0.661,	0.339,	0.};
	private static double[] Zero_A_fourth = new double[] {0.532,	0.000,	0.468,	0.000};
	private static double[] Zero_A_fifth = new double[] {0.168,	0.348,	0.378,	0.039,	0.678,	0.412};
					
	private static double[] One_A_first = new double[] {0.510,	0.102,	0.331,	0.057};
	private static double[] One_A_second = new double[] {0.305,	0.183,	0.000,	0.512};
	private static double[] One_A_third = new double[] {0.000,	1.000,	0.000,	0.000};
	private static double[] One_A_fourth = new double[] {0.578,	0.207,	0.215,	0.000};
	private static double[] One_A_fifth = new double[] {0.144,	0.023,	0.283,	0.557,	0.814,	0.898};
		
	private static double[] Two_A_first = new double[] {0.411,	0.118,	0.351,	0.120};
	private static double[] Two_A_second = new double[] {0.086,	0.396,	0.072,	0.446};
	private static double[] Two_A_third = new double[] {0.000,	0.345,	0.343,	0.311};
	private static double[] Two_A_fourth = new double[] {0.325,	0.029,	0.401,	0.245};
	private static double[] Two_A_fifth = new double[] {0.151,	0.181,	0.531,	0.292,	1.885,	0.130};
				
	private static double[] Three_A_first = new double[] {0.384,	0.108,	0.309,	0.198};
	private static double[] Three_A_second = new double[] {0.066,	0.393,	0.072,	0.469};
	private static double[] Three_A_third = new double[] {0.161,	0.341,	0.479,	0.019};
	private static double[] Three_A_fourth = new double[] {0.289,	0.138,	0.195,	0.378};
	private static double[] Three_A_fifth = new double[] {0.245,	0.228,	0.534,	0.279,	1.131,	0.163};
		
	private static double[] Four_A_first = new double[] {0.588,	0.000,	0.000,	0.412};
	private static double[] Four_A_second = new double[] {0.024,	0.722,	0.013,	0.242};
	private static double[] Four_A_third = new double[] {0.086,	0.479,	0.343,	0.092};
	private static double[] Four_A_fourth = new double[] {0.428,	0.014,	0.487,	0.071};
	private static double[] Four_A_fifth = new double[] {0.051,	0.228,	0.198,	0.774,	0.572,	0.533};
		
	private static double[] Five_A_first = new double[] {0.343,	0.114,	0.104,	0.440};
	private static double[] Five_A_second = new double[] {0.003,	0.472,	0.209,	0.316};
	private static double[] Five_A_third = new double[] {0.220,	0.191,	0.459,	0.130};
	private static double[] Five_A_fourth = new double[] {0.273,	0.151,	0.336,	0.239};
	private static double[] Five_A_fifth = new double[] {0.146,	0.175,	0.375,	0.383,	2.098,	0.278};
		
	private static double[] Six_A_first = new double[] {0.408,	0.083,	0.000,	0.510};
	private static double[] Six_A_second = new double[] {0.119,	0.339,	0.410,	0.131};
	private static double[] Six_A_third = new double[] {0.014,	0.535,	0.113,	0.338};
	private static double[] Six_A_fourth = new double[] {0.381,	0.130,	0.487,	0.002};
	private static double[] Six_A_fifth = new double[] {0.190,	0.243,	0.498,	0.177,	1.123,	0.207};
		
	private static double[] Seven_A_first = new double[] {0.369,	0.030,	0.394,	0.207};
	private static double[] Seven_A_second = new double[] {0.140,	0.153,	0.019,	0.688};
	private static double[] Seven_A_third = new double[] {0.000,	0.665,	0.335,	0.000};
	private static double[] Seven_A_fourth = new double[] {0.445,	0.243,	0.194,	0.119};
	private static double[] Seven_A_fifth = new double[] {0.000,	0.480,	0.089,	0.438,	1.503,	0.125};
				
	private static double[] Eight_A_first = new double[] {0.544,	0.000,	0.060,	0.396};
	private static double[] Eight_A_second = new double[] {0.000,	0.550,	0.103,	0.347};
	private static double[] Eight_A_third = new double[] {0.000,	0.554,	0.373,	0.073};
	private static double[] Eight_A_fourth = new double[] {0.471,	0.066,	0.350,	0.114};
	private static double[] Eight_A_fifth = new double[] {0.205,	0.268,	0.433,	0.100,	0.720,	0.260};
		
	private static double[] Nine_A_first = new double[] {0.407,	0.082,	0.023,	0.488};
	private static double[] Nine_A_second = new double[] {0.000,	0.752,	0.161,	0.087};
	private static double[] Nine_A_third = new double[] {0.309,	0.084,	0.436,	0.172};
	private static double[] Nine_A_fourth = new double[] {0.261,	0.159,	0.309,	0.270};
	private static double[] Nine_A_fifth = new double[] {0.205,	0.221,	0.474,	0.190,	1.064,	0.529};
		

		
		
	/* left column
	 K, h, k, m, n, r
	 M, N, i, l, I, E, F, L, H
	 c-shaped left side
	 C, G, c
	 70 degree
	 V, W, v , w
	 curves
	 J, j, S, s, U, a, f, u, 2, 3, 5
		
	 90 degree angles
	 T, t, 4
		
	 X, Y, Z
	 x, y, z
	 1, 7
	 */
	public static char[] zeroLoop(HashMap<Integer, double[]> hMap) {
		
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[42];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		double[] fifthUnknown = hMap.get(4);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		double[] resultFive = new double[6];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], K_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], K_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], K_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], K_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], K_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], K_A_fifth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		double five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		double aver = (o+t+thr+f+five)/5;
		
		double percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'K');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], h_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], h_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], h_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], h_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], h_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], h_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'h');
		
		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], k_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], k_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], k_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], k_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], k_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], k_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'k');
		
		resultArr[2] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], m_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], m_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], m_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], m_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], m_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], m_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'm');
		
		resultArr[3] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], n_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], n_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], n_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], n_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], n_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], n_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'n');
		
		resultArr[4] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], r_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], r_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], r_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], r_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], r_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], r_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'r');
		
		resultArr[5] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], M_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], M_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], M_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], M_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], M_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], M_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'M');
		
		resultArr[6] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], N_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], N_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], N_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], N_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], N_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], N_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'N');
		
		resultArr[7] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], i_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], i_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], i_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], i_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], i_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], i_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'i');
		
		resultArr[8] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], l_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], l_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], l_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], l_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], l_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], l_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'l');
		
		resultArr[9] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], I_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], I_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], I_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], I_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], I_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], I_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'I');
		
		resultArr[10] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], E_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], E_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], E_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], E_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], E_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], E_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'E');
		
		resultArr[11] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], F_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], F_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], F_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], F_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], F_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], F_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'F');
		
		resultArr[12] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], L_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], L_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], L_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], L_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], L_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], L_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'L');
		
		resultArr[13] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], H_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], H_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], H_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], H_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], H_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], H_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		aver = (o+t+thr+f)/4;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'H');
		
		resultArr[14] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], C_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], C_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], C_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], C_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], C_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], C_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'C');
		
		resultArr[15] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], c_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], c_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], c_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], c_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], c_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], c_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'c');

		resultArr[16] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], G_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], G_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], G_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], G_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], G_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], G_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'G');

		resultArr[17] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], V_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], V_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], V_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], V_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], V_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], V_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'V');
		
		resultArr[18] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], W_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], W_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], W_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], W_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], W_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], W_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'W');

		resultArr[19] = percentResult;
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], v_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], v_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], v_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], v_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], v_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], v_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'v');
		
		resultArr[20] = percentResult;
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], w_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], w_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], w_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], w_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], w_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], w_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'w');

		resultArr[21] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], J_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], J_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], J_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], J_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], J_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], J_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'J');

		resultArr[22] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], j_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], j_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], j_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], j_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], j_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], j_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'j');

		resultArr[23] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], S_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], S_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], S_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], S_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], S_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], S_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'S');

		resultArr[24] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], s_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], s_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], s_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], s_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], s_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], s_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 's');

		resultArr[25] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], U_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], U_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], U_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], U_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], U_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], U_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'U');

		resultArr[26] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], f_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], f_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], f_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], f_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], f_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], f_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'f');

		resultArr[27] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], u_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], u_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], u_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], u_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], u_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], u_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'u');

		resultArr[28] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Two_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Two_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Two_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Two_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Two_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Two_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '2');

		resultArr[29] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Three_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Three_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Three_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Three_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Three_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Three_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '3');

		resultArr[30] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Five_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Five_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Five_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Five_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Five_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Five_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '5');

		resultArr[31] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], T_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], T_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], T_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], T_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], T_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], T_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'T');

		resultArr[32] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], t_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], t_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], t_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], t_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], t_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], t_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 't');

		resultArr[33] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		

		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], X_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], X_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], X_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], X_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], X_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], X_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'X');

		resultArr[34] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Y_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Y_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Y_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Y_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Y_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Y_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'Y');

		resultArr[35] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Z_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Z_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Z_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Z_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Z_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Z_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'Z');

		resultArr[36] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], x_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], x_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], x_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], x_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], x_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], x_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'x');

		resultArr[37] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], y_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], y_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], y_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], y_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], y_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], y_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'y');
		
		resultArr[38] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], z_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], z_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], z_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], z_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], z_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], z_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'z');

		resultArr[39] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], One_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], One_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], One_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], One_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], One_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], One_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '1');

		resultArr[40] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Seven_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Seven_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Seven_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Seven_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Seven_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Seven_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '7');

		resultArr[41] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////////////////////////
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}

		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);
		
		char[] temp = new char[6];
		if (s.length()==3) {
			temp[4]='0';
			temp[5]='0';
		}
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) {
			temp[4] = s.charAt(3);
		}
		else if (s.length()==5) {
			temp[4] = s.charAt(3);
			temp[5] = s.charAt(4);
		}

		return temp;
	}

	
	/* c-shaped left side
	c-shaped left side
	 e, o, O, Q, 6, 0
	
	 A
	
	 left column
	 D, P, R, b, p
	 
	
	right column
	 d, a,q
	*/ 
	public static char[] oneLoop(HashMap<Integer, double[]> hMap) {
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[19];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		double[] fifthUnknown = hMap.get(4);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		double[] resultFive = new double[6];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], e_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], e_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], e_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], e_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], e_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], e_A_fifth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		double five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		double aver = (o+t+thr+f+five)/5;
		
		double percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'e');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], o_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], o_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], o_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], o_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], o_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], o_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'o');

		resultArr[1] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], O_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], O_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], O_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], O_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], O_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], O_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'O');

		resultArr[2] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Q_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Q_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Q_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Q_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Q_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Q_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'Q');

		resultArr[3] = percentResult;
		
		
		//////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], D_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], D_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], D_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], D_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], D_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], D_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'D');
		
		resultArr[4] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], P_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], P_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], P_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], P_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], P_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], P_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'P');
		
		resultArr[5] = percentResult;
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], R_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], R_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], R_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], R_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], R_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], R_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'R');
		
		resultArr[6] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], b_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], b_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], b_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], b_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], b_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], b_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'b');
		
		resultArr[7] = percentResult;
		
		//////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], p_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], p_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], p_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], p_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], p_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], p_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'p');
		
		resultArr[8] = percentResult;
		
		/////////////////
		
		
		///////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], d_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], d_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], d_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], d_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], d_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], d_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'd');
		
		resultArr[9] = percentResult;
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], a_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], a_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], a_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], a_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], a_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], a_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'a');

		resultArr[10] = percentResult;
		
		////////////////////////////////////////////////////////////////////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], q_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], q_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], q_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], q_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], q_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], q_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'q');
		
		resultArr[11] = percentResult;
		
		
		//////////////
	
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], A_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], A_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], A_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], A_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], A_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], A_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'A');
		
		resultArr[12] = percentResult;
		
		
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Zero_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Zero_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Zero_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Zero_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Zero_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Zero_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '0');
		
		resultArr[13] = percentResult;
	
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Six_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Six_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Six_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Six_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Six_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Six_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '6');
		
		resultArr[14] = percentResult;
		
		
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Nine_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Nine_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Nine_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Nine_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Nine_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Nine_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '9');
		
		resultArr[15] = percentResult;
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], g_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], g_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], g_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], g_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], g_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], g_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'g');

		resultArr[16] = percentResult;
		
		
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Four_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Four_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Four_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Four_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Four_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Four_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '4');
		
		resultArr[17] = percentResult;
			
		///////////
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], a_Custom1_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], a_Custom1_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], a_Custom1_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], a_Custom1_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], a_Custom1_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], a_Custom1_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'a');
		
		resultArr[18] = percentResult;
	
		///////////
		
		
		
		//////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);		
		
		char[] temp = new char[6];
		if (s.length()==3) {
			temp[4]='0';
			temp[5]='0';
		}
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) {
			temp[4] = s.charAt(3);
		}
		else if (s.length()==5) {
			temp[4] = s.charAt(3);
			temp[5] = s.charAt(4);
		}

		return temp;
	}
	
	
	/*
	 B, 8, g
	*/ 
	public static char[] twoLoop(HashMap<Integer, double[]> hMap) {
		
		HashMap<Double, Character> percentageHMap = new HashMap<Double, Character>();
		
		
		double[] resultArr = new double[2];
		
		double[] firstUnknown = hMap.get(0);
		double[] secondUnknown = hMap.get(1);
		double[] thirdUnknown = hMap.get(2);
		double[] fourthUnknown = hMap.get(3);
		double[] fifthUnknown = hMap.get(4);
		
		double[] resultOne = new double[4];
		double[] resultTwo = new double[4];
		double[] resultThree = new double[4];
		double[] resultFour = new double[4];
		double[] resultFive = new double[6];
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], B_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], B_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], B_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], B_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], B_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], B_A_fifth[i]);
		}
		
		double o = 0.0;
		double t = 0.0;
		double thr = 0.0;
		double f = 0.0;
		double five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		
		double aver = (o+t+thr+f+five)/5;
		
		double percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, 'B');
		
		resultArr[0] = percentResult;
		
		//////
		
		
		for (int i=0;i<4;i++) {
			resultOne[i] = percentSimilarityBetweenTwoDoubles(firstUnknown[i], Eight_A_first[i]);
			resultTwo[i] = percentSimilarityBetweenTwoDoubles(secondUnknown[i], Eight_A_second[i]);
			resultThree[i] = percentSimilarityBetweenTwoDoubles(thirdUnknown[i], Eight_A_third[i]);
			resultFour[i] = percentSimilarityBetweenTwoDoubles(fourthUnknown[i], Eight_A_fourth[i]);
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Eight_A_fifth[i]);
		}
		for (int i=4;i<6;i++) {
			resultFive[i] = percentSimilarityBetweenTwoDoubles(fifthUnknown[i], Eight_A_fifth[i]);
		}
		
		o = 0.0;
		t = 0.0;
		thr = 0.0;
		f = 0.0;
		five = 0.0;
		
		for (int i=0;i<4;i++) {
			o+=resultOne[i];
		}
		for (int i=0;i<4;i++) {
			t+=resultTwo[i];
		}
		for (int i=0;i<4;i++) {
			thr+=resultThree[i];
		}
		for (int i=0;i<4;i++) {
			f+=resultFour[i];
		}
		for (int i=0;i<6;i++) {
			five+=resultFive[i];
		}
		
		o = o/4;
		t = t/4;
		thr = thr/4;
		f = f/4;
		five = five/6;
		
		aver = (o+t+thr+f+five)/5;
		
		percentResult = round(aver,6);
		
		percentageHMap.put(percentResult, '8');

		resultArr[1] = percentResult;
		
		///////////

		
		//////////////
		
		double highestPercentage=0.0;
		
		for (int i=0;i<resultArr.length;i++) {
			if (resultArr[i]>highestPercentage) highestPercentage=resultArr[i];
		}
		
		char foundLetter = percentageHMap.get(highestPercentage);
		String s = Double.toString(highestPercentage);

		char[] temp = new char[6];
		if (s.length()==3) {
			temp[4]='0';
			temp[5]='0';
		}
		temp[0] = foundLetter;
		temp[1] = s.charAt(0);
		temp[2] = s.charAt(1);
		temp[3] = s.charAt(2);
		if (s.length()==4) {
			temp[4] = s.charAt(3);
		}
		else if (s.length()==5) {
			temp[4] = s.charAt(3);
			temp[5] = s.charAt(4);
		}

		return temp;
	}
	
	

	private static double percentSimilarityBetweenTwoDoubles(double A, double B) {
		double result=0.0;
		if (A==0.0) {
			A=0.01;
		}
		if (B==0.0) {
			B=0.01;
		}
		
		if (A>B) {
			result = round((B/A),2);
		}
		else if (B>A) {
			result = round((A/B),2);
		}
		else result = 1.0;
		


		return result;
	}
	
	/*
	 * round up decimal values to 2 places
	 * */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
